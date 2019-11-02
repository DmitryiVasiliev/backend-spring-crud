package com.spring.crud;

import com.spring.crud.entity.Course;
import com.spring.crud.repository.CourseCrudRepository;
import com.spring.crud.service.DataService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@TestPropertySource("/application-test.properties")
class CrudApplicationTests {

    @Autowired
    private CourseCrudRepository crudRepository;

    @Autowired
    private DataService courseDataService;

    @Test
    public void testAddCourseToDB() {
        Course course = new Course("test1", "test2");
        Course courseSaved = crudRepository.save(course);
        Course course1 = crudRepository.findById(courseSaved.getId()).get();
        Course course2 = (Course) courseDataService.findById(courseSaved.getId());
        assertThat(course1.getId()).isEqualTo(course2.getId());
    }

}
