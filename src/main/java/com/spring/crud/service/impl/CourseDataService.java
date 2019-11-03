package com.spring.crud.service.impl;

import com.spring.crud.entity.Course;
import com.spring.crud.repository.CourseCrudRepository;
import com.spring.crud.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseDataService implements DataService<Course> {
    @Autowired
    protected CourseCrudRepository crudRepository;

    @Override
    public Course addEntity(Course entity) {
        return crudRepository.saveAndFlush(entity);
    }

    @Override
    public void delete(Long id) {
        crudRepository.deleteById(id);
    }

    @Override
    public Course findById(Long id) {
        return crudRepository.findById(id).get();
    }

    @Override
    public Course update(Course entity) {
        return crudRepository.save(entity);
    }

    @Override
    public List<Course> findAll() {
        return crudRepository.findAll();
    }
}
