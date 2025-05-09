package com.ToDoList.Manager.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

@Component
@Getter
@NoArgsConstructor
public class AdminUser extends User{

    private final Long id = 8888L ;
    private final String login = "admin";
    private final String password = "admin";
    private final String number = "+79273955345";
    private final String email = "kill.mill.kill476@gmail.com";
    private final String telegram = "tg:@nikitos322";
    private final String firstName = "Nikita";
    private final String secondName = "Kochegarov";
    private final Integer age = 20;
    private final GradeOfUsers grade = GradeOfUsers.ADMIN;


}









