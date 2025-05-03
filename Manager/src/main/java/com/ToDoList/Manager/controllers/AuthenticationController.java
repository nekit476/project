package com.ToDoList.Manager.controllers;

import com.ToDoList.Manager.Model.User;
import com.ToDoList.Manager.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthenticationController {

    private final UserService userService;

    public AuthenticationController(UserService loginAndPasswordCheck) {
        this.userService = loginAndPasswordCheck;
    }


    @GetMapping("/authentication")
    public String authentication(){

        return "Authentication";
    }


    @PostMapping("/authentication")
    public String userLC(@RequestParam String login,
                         @RequestParam String password,
                         HttpSession httpSession){

        User user = userService.getUserByLoginAndCheckPasswordOrReturnNull(login, password);


        if(user == null){

            System.out.println("Пароль не верный или пользователь не найден");
            return "redirect:/authentication";

        }else if(user.getLogin().equals("admin")){

            httpSession.setAttribute("admin", user);
            return "redirect:/admin";
        }else{

            httpSession.setAttribute("user", user);
            return "redirect:/main";
        }


    }









}
