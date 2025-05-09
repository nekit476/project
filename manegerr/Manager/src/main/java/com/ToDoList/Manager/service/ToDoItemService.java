package com.ToDoList.Manager.service;

import com.ToDoList.Manager.Model.ToDoItem;
import com.ToDoList.Manager.Model.User;
import com.ToDoList.Manager.repositories.ToDoItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoItemService {

    private final ToDoItemRepository toDoItemRepository;

    public ToDoItemService(ToDoItemRepository toDoItemRepository) {
        this.toDoItemRepository = toDoItemRepository;
    }

    public void addTask(ToDoItem toDoItem){

        toDoItemRepository.save(toDoItem);

    }

    public void deleteTask(Long taskId){

        toDoItemRepository.deleteById(taskId);
    }


    public List<ToDoItem> getListOfUserTasks(Long id){

        List<ToDoItem> userTasks;
        userTasks = toDoItemRepository.findByUserId(id);

        return userTasks;

    }
}
