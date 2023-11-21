package org.launchcode.the_bar_helper.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.launchcode.the_bar_helper.data.UserRepository;
import org.launchcode.the_bar_helper.models.User;
import org.launchcode.the_bar_helper.models.dto.LoginFormDTO;
import org.launchcode.the_bar_helper.models.dto.RegistrationFormDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class AuthenticationController {

    @Autowired
    UserRepository userRepository;

    private static final String userSessionKey = "user";

    private static void setUserInSession(HttpSession session, User user) {
        session.setAttribute(userSessionKey, user.getId());
    }

    public  User getUserFromSession(HttpSession session) {
        Integer userId = (Integer) session.getAttribute(userSessionKey);

        if (userId == null) {
            return null;
        }

        Optional<User> userOptional = userRepository.findById(userId);

        if (userOptional.isEmpty()) {
            return null;
        }

        return userOptional.get();
    }

    @GetMapping("register")
    public String displayRegistrationForm(Model model) {
        model.addAttribute(new RegistrationFormDTO());
        return "register";
    }

    @PostMapping("register")
    public String processRegistrationForm(@ModelAttribute @Valid RegistrationFormDTO registrationFormDTO,
                                          Errors errors,
                                          Model model,
                                          HttpServletRequest request) {
        if (errors.hasErrors()) {
            return "register";
        }

        User existingUser = userRepository.findByUsername(registrationFormDTO.getUsername());

        if (existingUser != null) {
            errors.rejectValue("username", "username.alreadyExists", "Username already exists.");
            return "register";
        }

        String password = registrationFormDTO.getPassword();
        String verifyPassword = registrationFormDTO.getVerifyPassword();
        if (!password.equals(verifyPassword)) {
            errors.rejectValue("verifyPassword", "password.mismatch", "Passwords do not match.");
            return "register";
        }
        User newUser = new User(registrationFormDTO.getUsername(), registrationFormDTO.getPassword());
        userRepository.save(newUser);
        setUserInSession(request.getSession(), newUser);
        return "redirect:/";
    }

    @GetMapping("login")
    public String displayLoginForm(Model model) {
        model.addAttribute(new LoginFormDTO());
        return "login";
    }

    @PostMapping("login")
    public String processLoginForm(@ModelAttribute @Valid LoginFormDTO loginFormDTO,
                                   Errors errors,
                                   HttpServletRequest request,
                                   Model model) {
        if (errors.hasErrors()) {
            return "register";
        }
        User existingUser = userRepository.findByUsername(loginFormDTO.getUsername());

        String password = loginFormDTO.getPassword();

        if (existingUser == null || !existingUser.isMatchingPassword(password)) {
            errors.rejectValue("password", "login.invalid", "Credentials invalid. Please try again.");
            return "login";
        }
        setUserInSession(request.getSession(), existingUser);
        return "redirect:/";
    }

    @GetMapping("logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:login";
    }

}
