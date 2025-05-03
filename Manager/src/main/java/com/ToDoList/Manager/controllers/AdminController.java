package com.ToDoList.Manager.controllers;


import com.ToDoList.Manager.Model.AdminUser;
import com.ToDoList.Manager.Model.ToDoItem;
import com.ToDoList.Manager.Model.User;
import com.ToDoList.Manager.service.AdminService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
