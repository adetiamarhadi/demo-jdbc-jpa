package com.github.adetiamarhadi.demojdbcjpa;

import com.github.adetiamarhadi.demojdbcjpa.entity.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import java.util.List;

@SpringBootTest
public class JPQLTest {

    @Autowired
    EntityManager entityManager;

    @Test
    public void test() {
        List<Course> courseList = entityManager.createNamedQuery("get_all_course", Course.class)
                .getResultList();
        System.out.println(courseList);
    }

    @Test
    public void testWhere() {
        List<Course> resultList = entityManager
                .createNamedQuery("get_all_100_steps_course", Course.class).getResultList();
        System.out.println(resultList);
    }

    @Test
    public void testGetCourseWithoutStudent() {
        List<Course> resultList = this.entityManager
                .createQuery("select c from Course c where c.students is empty", Course.class).getResultList();
        System.out.println("course without student:");
        resultList.stream().map(l -> l.getName()).forEach(System.out::println);
    }

    @Test
    public void testGetCourseWithStudentAtLeast2() {
        List<Course> resultList = this.entityManager
                .createQuery("select c from Course c where size(c.students) >= 2", Course.class).getResultList();
        System.out.println("course with at least 2 student:");
        resultList.stream().map(Course::getName).forEach(System.out::println);
    }

    @Test
    public void testGetCourseWithStudentByOrder() {
        List<Course> resultList = this.entityManager
                .createQuery("select c from Course c order by size(c.students) desc", Course.class).getResultList();
        System.out.println("ordered course with student:");
        resultList.stream().map(Course::getName).forEach(System.out::println);
    }
}
