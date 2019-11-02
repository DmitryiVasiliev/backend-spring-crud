package com.spring.crud.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String description;

    public Course() {
    }

    public Course(String username, String description) {
        this.username = username;
        this.description = description;
    }
}
