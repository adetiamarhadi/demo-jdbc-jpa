package com.github.adetiamarhadi.demojdbcjpa.jpa;

import com.github.adetiamarhadi.demojdbcjpa.entity.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    CourseRepository courseRepository;

    @Test
    void findById() {
        Course course = this.courseRepository.findById(1004L);
        assertEquals("Udemy - Hibernate", course.getName());
    }

    @Test
    void deleteById() {
        this.courseRepository.deleteById(1006L);
        Course course = this.courseRepository.findById(1006L);
        assertNull(course);
    }
}