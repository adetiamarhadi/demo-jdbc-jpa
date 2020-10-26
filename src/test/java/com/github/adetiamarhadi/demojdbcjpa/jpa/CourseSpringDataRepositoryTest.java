package com.github.adetiamarhadi.demojdbcjpa.jpa;

import com.github.adetiamarhadi.demojdbcjpa.entity.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;
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

    @Test
    @DirtiesContext
    public void testInsertAndUpdate() {
        Course course = Course.builder()
                .name("Ansible in 100 Steps")
                .build();
        this.repository.save(course);

        course.setName("Ansible in 100 Steps - Updated");
        this.repository.save(course);
    }

    @Test
    public void testSelectAndCount() {
        List<Course> courses = this.repository.findAll();
        long count = this.repository.count();
        System.out.println("all courses");
        courses.stream().map(course -> course.getName()).forEach(System.out::println);
        System.out.println("count : " + count);
    }

    @Test
    public void testFindAllWithOrder() {
        Sort sort = Sort.by(Sort.Direction.DESC, "name");
        List<Course> courses = this.repository.findAll(sort);
        System.out.println("all sorting courses");
        courses.stream().map(course -> course.getName()).forEach(System.out::println);
    }
}
