package com.github.adetiamarhadi.demojdbcjpa.jpa;

import com.github.adetiamarhadi.demojdbcjpa.entity.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    CourseRepository courseRepository;

    @Test
    void findById() {
        Course course = this.courseRepository.findById(1004L);
        assertEquals("updated course", course.getName());
    }

    @Test
    void deleteById() {
        this.courseRepository.deleteById(1006L);
        Course course = this.courseRepository.findById(1006L);
        assertNull(course);
    }

    @Test
    void save() {
        Course kafkaCourse = Course.builder()
                .name("Udemy - Kafka Course")
                .build();
        this.courseRepository.save(kafkaCourse);
        Course course = this.courseRepository.findById(3L);
        assertEquals("Udemy - Kafka Course", course.getName());
    }

    @Test
    void update() {
        Course course = this.courseRepository.findById(1007L);
        assertEquals("Udemy - Elastic Search", course.getName());
    }

    @Test
    @DirtiesContext
    void playWithEntityManager() {
        this.courseRepository.playWithEntityManager();
    }
}