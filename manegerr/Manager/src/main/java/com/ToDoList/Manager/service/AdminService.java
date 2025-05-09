package com.ToDoList.Manager.service;

import com.ToDoList.Manager.Model.GradeOfUsers;
import com.ToDoList.Manager.Model.ToDoItem;
import com.ToDoList.Manager.Model.User;
import com.ToDoList.Manager.repositories.ToDoItemRepository;
import com.ToDoList.Manager.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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


    public boolean setUserGradeModerator(String login){

        Optional<User> findUser = userRepository.findByLogin(login);
        if(findUser.isEmpty()){

            return false;
        }else{

            User user = findUser.get();
            user.setGrade(GradeOfUsers.MODERATOR);
            userRepository.save(user);
            return true;
        }
    }


    public  boolean deleteUserGradeModerator(String login){
        Optional<User> findUser = userRepository.findByLogin(login);
        if(findUser.isEmpty()){

            return false;
        }else{

            User user = findUser.get();
            user.setGrade(GradeOfUsers.USER);
            userRepository.save(user);
            return true;
        }
    }

    public void addTask(String taskName, String description){
        ToDoItem newTask = new ToDoItem(taskName, description, null);
        toDoItemRepository.save(newTask);
    }


    public void deleteTask(Number id){

        Long valueNumber = id.longValue();
        toDoItemRepository.deleteById(valueNumber);
    }




}
