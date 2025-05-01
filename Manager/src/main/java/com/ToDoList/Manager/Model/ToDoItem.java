package com.ToDoList.Manager.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ToDoItem {

    @Id
    @GeneratedValue
    private Long id;
    private Long userId;
    private String name;
    private String description;




    public ToDoItem(String name, String description, Long userId){

        this.name = name;
        this.description = description;
        this.userId = userId;

    }
}
