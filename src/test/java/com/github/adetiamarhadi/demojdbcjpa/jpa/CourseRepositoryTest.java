package com.github.adetiamarhadi.demojdbcjpa.jpa;

import com.github.adetiamarhadi.demojdbcjpa.entity.Course;
import com.github.adetiamarhadi.demojdbcjpa.entity.Review;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    EntityManager entityManager;

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

    @Test
    @Transactional
    void getReviews() {
        Course course = this.courseRepository.findById(1007L);
        List<Review> reviews = course.getReviews();
        reviews.forEach(System.out::println);
    }

    @Test
    void getCourse() {
        Review review = this.entityManager.find(Review.class, 400001);
        Course course = review.getCourse();
        System.out.println(course.getName());
    }

    @Test
    @Transactional
    void getCourseAndStudent() {
        Course course = this.entityManager.find(Course.class, 1004L);
        System.out.println(course.getName());
        course.getStudents().forEach(s -> System.out.println(s.getName()));
    }
}