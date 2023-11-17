package org.launchcode.the_bar_helper.controllers;

import jakarta.validation.Valid;
import org.launchcode.the_bar_helper.data.EmployeeInformationRepository;
import org.launchcode.the_bar_helper.data.EmployeesRepository;
import org.launchcode.the_bar_helper.data.PositionRepository;
import org.launchcode.the_bar_helper.models.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("employees")
public class EmployeesController {

    @Autowired
    private EmployeesRepository employeesRepository;

    @Autowired
    private PositionRepository positionRepository;

    @Autowired
    private EmployeeInformationRepository employeeInformationRepository;

    @GetMapping("add")
    public String displayAddEmployeePage(Model model) {
        model.addAttribute("title", "Add Employee");
        model.addAttribute("positionType", positionRepository.findAll());
        model.addAttribute(new Employees());
        return "employees/add";
    }

    @PostMapping("add")
    public  String processAddEmployeePage(@ModelAttribute @Valid Employees employees, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("employees", employees);
            model.addAttribute("errors", errors);
            return "employees/add";
        } else {
            employeesRepository.save(employees);
        }
        return "redirect:list";
    }
    @GetMapping("list")
    public String displayListEmployeePage(Model model) {
        model.addAttribute("title", "Employees");
        model.addAttribute("employeeList", employeesRepository.findAll());
        model.addAttribute("positionType", positionRepository.findAll());
        model.addAttribute("employeeInformationRepository", employeeInformationRepository);
        return "employees/list";
    }

    @GetMapping("delete")
    public String displayDeleteEmployeePage(Model model) {
        model.addAttribute("title", "Delete Employee");
        model.addAttribute("employeeList", employeesRepository.findAll());
        return "employees/delete";
    }

    @PostMapping("delete")
    public String processDeleteEmployeePage(@RequestParam(required = false) int[] employeeIds) {
        for (int id : employeeIds) {
            employeesRepository.deleteById(id);
        }
        return "redirect:list";
    }
}
