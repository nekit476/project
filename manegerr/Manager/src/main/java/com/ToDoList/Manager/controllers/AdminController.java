package com.ToDoList.Manager.controllers;


import com.ToDoList.Manager.Model.AdminUser;
import com.ToDoList.Manager.Model.ToDoItem;
import com.ToDoList.Manager.Model.User;
import com.ToDoList.Manager.service.AdminService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AdminController {
    private final AdminService adminService;


    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/admin")
    public String admin(HttpSession httpSession, Model model){

        AdminUser adminUser = (AdminUser) httpSession.getAttribute("admin");
        List<ToDoItem> listOfTask = adminService.getAllTasks();
        model.addAttribute("listOfTasks", listOfTask);
        List<User> listOfUser = adminService.getAllUsers();
        model.addAttribute("listOfUsers", listOfUser);
        return "admin";
    }

    @PostMapping("/addModerator")
    public String addModerator(@RequestParam String login){

        adminService.setUserGradeModerator(login);
        return "redirect:/admin";
    }

    @PostMapping("/deleteModerator")
    public String deleteModerator(@RequestParam String login){

        adminService.deleteUserGradeModerator(login);
        return "redirect:/admin";
    }

    @PostMapping("/addTask")
    public String addTask(@RequestParam String taskName,
                          @RequestParam String description){
        adminService.addTask(taskName, description);
        return "redirect:/admin";
    }

    @PostMapping("/deleteTask")
    public String addTask(@RequestParam Number taskId){


        adminService.deleteTask(taskId);
        return "redirect:/admin";
    }



}
