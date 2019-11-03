package com.spring.crud.controller;

import com.spring.crud.entity.Course;
import com.spring.crud.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
public class CourseController {

    @Autowired
    private DataService<Course> coursesHardcodedService;

    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return coursesHardcodedService.findAll();
    }

    @DeleteMapping("/courses/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCourse(@PathVariable Long id) {
        coursesHardcodedService.delete(id);
    }

    @GetMapping("/courses/{id}")
    public Course getCourse(@PathVariable Long id) {
        return coursesHardcodedService.findById(id);
    }

    @PutMapping("/courses/{id}")
    public ResponseEntity<Course> updateCourse(@RequestBody Course course, @PathVariable Long id) {
        Course updateCourse = coursesHardcodedService.update(course);
        return new ResponseEntity<Course>(updateCourse, HttpStatus.OK);
    }

    @PostMapping("/courses")
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        Course createCourse = coursesHardcodedService.addEntity(course);
        return new ResponseEntity<>(createCourse, HttpStatus.OK);
    }
}
