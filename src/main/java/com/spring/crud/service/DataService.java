package com.spring.crud.service;

import com.spring.crud.entity.Course;

import java.util.List;
import java.util.UUID;

public interface DataService<T> {

    T addEntity(T entity);

    void delete(Long id);

    T findById(Long id);

    T update(T entity);

    List<T> findAll();
}
