package com.spring.crud.repository;

import com.spring.crud.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CourseCrudRepository extends JpaRepository<Course, Long> {
}
