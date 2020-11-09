package com.github.adetiamarhadi.demojdbcjpa;

import com.github.adetiamarhadi.demojdbcjpa.entity.Course;
import com.github.adetiamarhadi.demojdbcjpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import java.util.List;

@SpringBootTest
public class PerformanceTuningTest {

    @Autowired
    EntityManager entityManager;

    @Test
    @Transactional
    public void creatingNPlusOneProblem() {

        List<Course> courses = this.entityManager.createNamedQuery("get_all_course", Course.class)
                .getResultList();
        for (Course course : courses) {
            System.out.println("course : " + course.getName());
            for (Student student : course.getStudents()) {
                System.out.println("student : " + student.getName());
            }
        }
    }

    @Test
    @Transactional
    public void solvingNPlusOneProblemWithEntityGraph() {

        EntityGraph<Course> entityGraph = this.entityManager.createEntityGraph(Course.class);
        entityGraph.addSubgraph("students");

        List<Course> courses = this.entityManager.createNamedQuery("get_all_course", Course.class)
                .setHint("javax.persistence.loadgraph", entityGraph)
                .getResultList();
        for (Course course : courses) {
            System.out.println("course : " + course.getName());
            for (Student student : course.getStudents()) {
                System.out.println("student : " + student.getName());
            }
        }
    }

    @Test
    @Transactional
    public void solvingNPlusOneProblemWithJoinFetch() {

        List<Course> courses = this.entityManager.createNamedQuery("get_all_course_join_fetch", Course.class)
                .getResultList();
        for (Course course : courses) {
            System.out.println("course : " + course.getName());
            for (Student student : course.getStudents()) {
                System.out.println("student : " + student.getName());
            }
        }
    }
}
