package com.ToDoList.Manager.service;

import com.ToDoList.Manager.Model.User;
import com.ToDoList.Manager.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {

        this.userRepository = userRepository;

    }

    public boolean addUser(User user){

        Optional<User> existingUser = userRepository.findByLogin(user.getLogin());
        if(existingUser.isEmpty()){

            userRepository.save(user);
            return true;

        }else{

            return false;
        }




    }

    public User getUserByLoginAndCheckPasswordOrReturnNull(String login, String password){

        Optional<User> findUser = userRepository.findByLogin(login);

        if(findUser.isEmpty()){

            return null;
        }else{

            User user = findUser.get();
            boolean isPasswordRight = checkLoginAndPassword(user, password);
            if(isPasswordRight){
                return user;

            }else {
                return null;
            }
        }
    }


    private boolean checkLoginAndPassword(User user, String password)  {

        if(user == null){

            System.out.println("Пользователь не найден");
            return false;
        }else if(user.getPassword().equals(password)){

            return true;
        }else{

            return false;
        }

    }





}
