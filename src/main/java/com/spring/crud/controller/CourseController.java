package com.spring.crud.controller;

import com.spring.crud.entity.Course;
import com.spring.crud.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
public class CourseController {
    @Autowired
    private DataService coursesHardcodedService;

    @GetMapping("/instructors/{username}/courses")
    public List getAllCourses(@PathVariable String username) {
        return coursesHardcodedService.findAll();
    }

    @DeleteMapping("/instructors/{username}/courses/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCourse(@PathVariable String username
            , @PathVariable Long id) {
        coursesHardcodedService.delete(id);
    }

    @GetMapping("/instructors/{username}/courses/{id}")
    public Course getCourse(@PathVariable String username
            , @PathVariable Long id) {
        return (Course) coursesHardcodedService.findById(id);
    }

    @PutMapping("/instructors/{username}/courses/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable String username,
                                               @PathVariable Long id, @RequestBody Course course) {
        Course updateCourse = (Course) coursesHardcodedService.addEntity(course);
        return new ResponseEntity<Course>(updateCourse, HttpStatus.OK);
    }

    @PostMapping("/instructors/{username}/courses")
    public ResponseEntity<Void> createCourse(@PathVariable String username,
                                             @RequestBody Course course) {
        Course createdCourse = (Course) coursesHardcodedService.update(course);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdCourse.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }
}
