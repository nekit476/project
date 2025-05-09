package com.ToDoList.Manager.controllers;



import com.ToDoList.Manager.Model.ToDoItem;
import com.ToDoList.Manager.Model.User;
import com.ToDoList.Manager.repositories.ToDoItemRepository;
import com.ToDoList.Manager.service.ToDoItemService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.List;

@Controller
public class MainController {



    private final ToDoItemService toDoItemService;

    public MainController(ToDoItemService toDoItemService) {
        this.toDoItemService = toDoItemService;
    }


    @GetMapping("/main")
    public String mainUser(Model model,
                           HttpSession httpSession,
                           ToDoItem newToDo){

        User user = (User) httpSession.getAttribute("user");
        model.addAttribute("user", user);

        model.addAttribute("allToDo", toDoItemService.getListOfUserTasks(user.getId()));


        model.addAttribute("newToDo", newToDo);

        return "main";
    }



    @PostMapping("/addToDo")
    public String addTask(ToDoItem newToDo,
                          HttpSession httpSession){

        User user = (User) httpSession.getAttribute("user");
        newToDo.setUserId(user.getId());
        toDoItemService.addTask(newToDo);
        return "redirect:/main";
    }

    @PostMapping("/delete/{id}")
    public String deleteTask(ToDoItem toDoItem){

        toDoItemService.deleteTask(toDoItem.getId());
        return "redirect:/main";
    }
}
