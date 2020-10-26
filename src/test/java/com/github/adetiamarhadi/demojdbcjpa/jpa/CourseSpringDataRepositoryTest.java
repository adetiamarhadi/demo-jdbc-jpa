package com.github.adetiamarhadi.demojdbcjpa.jpa;

import com.github.adetiamarhadi.demojdbcjpa.entity.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class CourseSpringDataRepositoryTest {

    @Autowired
    CourseSpringDataRepository repository;

    @Test
    public void testFindByIdCoursePresent() {
        Optional<Course> course = this.repository.findById(1008L);
        assertTrue(course.isPresent());
    }

    @Test
    public void testFindByIdCourseNotPresent() {
        Optional<Course> course = this.repository.findById(2222L);
        assertFalse(course.isPresent());
    }
}
