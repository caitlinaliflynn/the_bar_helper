package org.launchcode.the_bar_helper.controllers;

import jakarta.validation.Valid;
import org.launchcode.the_bar_helper.data.CompletedTasksRepository;
import org.launchcode.the_bar_helper.data.EmployeesRepository;
import org.launchcode.the_bar_helper.models.CompletedTasks;
import org.launchcode.the_bar_helper.models.TaskType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("tasks/completed")
public class CompletedTasksController {

    @Autowired
    private CompletedTasksRepository completedTasksRepository;

    @Autowired
    private EmployeesRepository employeesRepository;

    @GetMapping("add")
    public String displayAddCompletedTasksPage(Model model) {
        model.addAttribute("title", "Add Completed Task");
        model.addAttribute(new CompletedTasks());
        model.addAttribute("completedTaskTypes", TaskType.values());
        model.addAttribute("employeesRepository", employeesRepository.findAll());
        return "tasks/add-completed";
    }

    @PostMapping("add")
    public String processAddCompletedTasksPage(@ModelAttribute @Valid CompletedTasks completedTasks, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("completedTasks", completedTasks);
            model.addAttribute("errors", errors);
            return "tasks/add-completed";
        } else {
            completedTasksRepository.save(completedTasks);
        }
        return  "redirect:list";
    }

    @GetMapping("list")
    public String displayListCompletedTasksPage(Model model) {
        model.addAttribute("title", "Completed Tasks List");
        model.addAttribute("completedTasksList", completedTasksRepository.findAll());
        model.addAttribute("employeesRepository", employeesRepository.findAll());
        return "tasks/list-completed";
    }

    @GetMapping("delete")
    public String displayDeleteCompletedTasksPage(Model model) {
        model.addAttribute("title", "Delete Completed Task");
        model.addAttribute("completedTasksList", completedTasksRepository.findAll());
        model.addAttribute("employeesRepository", employeesRepository.findAll());
        return "tasks/delete-completed";
    }

    @PostMapping("delete")
    public String processDeleteCompletedTasksPage(@RequestParam(required = false) int[] completedTaskIds) {
        for (int id : completedTaskIds) {
            completedTasksRepository.deleteById(id);
        }
        return "redirect:list";
    }
}
