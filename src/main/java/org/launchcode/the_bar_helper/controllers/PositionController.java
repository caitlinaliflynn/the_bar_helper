package org.launchcode.the_bar_helper.controllers;

import jakarta.validation.Valid;
import org.launchcode.the_bar_helper.data.EmployeeInformationRepository;
import org.launchcode.the_bar_helper.data.EmployeesRepository;
import org.launchcode.the_bar_helper.data.PositionRepository;
import org.launchcode.the_bar_helper.models.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("position")
public class PositionController {

    @Autowired
    private EmployeesRepository employeesRepository;

    @Autowired
    private PositionRepository positionRepository;


    @Autowired
    private EmployeeInformationRepository employeeInformationRepository;

    @GetMapping("add")
    public String displayAddPositionPage(Model model) {
        model.addAttribute("title", "Add Position");
        model.addAttribute(new Position());
        model.addAttribute("employeesRepository", employeesRepository.findAll());
        model.addAttribute("employeesInformationRepository", employeeInformationRepository.findAll());
        return "position/add";
    }

    @PostMapping("add")
    public String processAddPositionPage(@ModelAttribute @Valid Position position, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("position", position);
            model.addAttribute("errors", errors);
            model.addAttribute("employeesRepository", employeesRepository.findAll());
            model.addAttribute("employeesInformationRepository", employeeInformationRepository.findAll());
            return "position/add";
        } else {
            positionRepository.save(position);
        }
        return "redirect:list";
    }

    @GetMapping("list")
    public String displayListPositionPage(Model model) {
        model.addAttribute("title", "Positions");
        model.addAttribute("positionList", positionRepository.findAll());
        model.addAttribute("employeesInformationRepository", employeeInformationRepository.findAll());
        model.addAttribute("employeesRepository", employeesRepository.findAll());
        return "position/list";
    }

    @GetMapping("delete")
    public String displayDeletePositionPage(Model model) {
        model.addAttribute("title", "Delete Position");
        model.addAttribute("positionList", positionRepository.findAll());
        return "position/delete";
    }

    @PostMapping("delete")
    public String processDeletePositionPage(@RequestParam(required = false) int[] positionIds) {
        for (int id : positionIds) {
            positionRepository.deleteById(id);
        }
        return "redirect:list";
    }
}
