package com.ToDoList.Manager.controllers;


import com.ToDoList.Manager.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import com.ToDoList.Manager.Model.User;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class RegistrationController {

    private final UserService userService;


    public RegistrationController(UserService userService) {

        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registration(Model model){

        model.addAttribute("user", new User());
        return "registration";
    }


    @PostMapping("/main")
    public String reg(@ModelAttribute("user") User user, HttpSession httpSession){

        boolean flag = userService.addUser(user);


        if(flag){
            httpSession.setAttribute("user", user);
            return "redirect:/main";
        }
        else{
            return "redirect:/registration";
        }


    }



}
