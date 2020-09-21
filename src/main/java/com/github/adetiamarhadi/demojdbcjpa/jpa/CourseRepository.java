package com.github.adetiamarhadi.demojdbcjpa.jpa;

import com.github.adetiamarhadi.demojdbcjpa.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional
public class CourseRepository {

    @Autowired
    EntityManager entityManager;

    public Course findById(Long id) {
        return this.entityManager.find(Course.class, id);
    }

    public void deleteById(Long id) {
        Course course = findById(id);
        this.entityManager.remove(course);
    }

    public void save(Course course) {
        this.entityManager.persist(course);
    }

    public Course update(Course course) {
        return this.entityManager.merge(course);
    }

    public void playWithEntityManager() {
        Course course = Course.builder()
                .name("web services in 100 steps")
                .build();
        entityManager.persist(course);
        course.setName("web services in 100 steps - updated");
    }
}
