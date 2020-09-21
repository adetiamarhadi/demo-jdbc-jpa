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
        entityManager.flush(); // auto commit
        course.setName("web services in 100 steps - updated");

        Course course2 = Course.builder()
                .name("angular in 100 steps")
                .build();
        entityManager.persist(course2);
        entityManager.flush(); // you should flush it, before detach
        entityManager.detach(course2); // will no longer update course2 or use clear() to detach all beans
        course2.setName("angular in 100 steps - updated");

        Course course3 = Course.builder()
                .name("jenkins in 100 steps")
                .build();
        entityManager.persist(course3);

        Course course4 = Course.builder()
                .name("grpc in 10 steps")
                .build();
        entityManager.persist(course4);

        entityManager.flush();

        course3.setName("jenkins in 100 steps - updated");
        course4.setName("grpc in 10 steps - updated");

        entityManager.refresh(course3);

        entityManager.flush();
    }
}
