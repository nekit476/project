package com.ToDoList.Manager.service;

import com.ToDoList.Manager.Model.ToDoItem;
import com.ToDoList.Manager.Model.User;
import com.ToDoList.Manager.repositories.ToDoItemRepository;
import com.ToDoList.Manager.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    private final UserRepository userRepository;
    private final ToDoItemRepository toDoItemRepository;

    public AdminService(UserRepository userRepository, ToDoItemRepository toDoItemRepository) {
        this.userRepository = userRepository;
        this.toDoItemRepository = toDoItemRepository;
    }


    public List<ToDoItem> getAllTasks(){

        List<ToDoItem> allTasks = toDoItemRepository.findAll();
        return allTasks;
    }

    public List<User> getAllUsers(){

        List<User> allUser = userRepository.findAll();
        return allUser;
    }




}
