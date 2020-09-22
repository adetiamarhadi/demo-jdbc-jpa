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
        List<Course> courseList = entityManager.createQuery("select c from Course c", Course.class)
                .getResultList();
        System.out.println(courseList);
    }

    @Test
    public void testWhere() {
        List<Course> resultList = entityManager
                .createQuery("select c from Course c where name like '%100 steps'", Course.class).getResultList();
        System.out.println(resultList);
    }
}
