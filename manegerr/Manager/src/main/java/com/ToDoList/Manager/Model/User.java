package com.ToDoList.Manager.Model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Users")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "secondName")
    private String secondName;

    @Column(name = "age")
    private Integer age;

    @Column(name = "role")
    private GradeOfUsers grade = GradeOfUsers.USER;


    public User(String login, String password, String firstName, String secondName,  Integer age){
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;

    }






}
