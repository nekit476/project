package com.ToDoList.Manager.Model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class AdminUser extends User{

    private final String login = "admin";
    private final String password = "admin";

    private final String number = "+79273955345";
    private final String email = "kill.mill.kill476@gmail.com";
    private final String telegram = "tg:@nikitos322";


}
