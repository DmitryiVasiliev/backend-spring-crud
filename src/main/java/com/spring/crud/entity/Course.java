package com.spring.crud.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    public Course() {
    }

    public Course(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
