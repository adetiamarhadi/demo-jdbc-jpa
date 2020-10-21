package com.github.adetiamarhadi.demojdbcjpa;

import com.github.adetiamarhadi.demojdbcjpa.entity.Course;
import com.github.adetiamarhadi.demojdbcjpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

@SpringBootTest
public class CriteriaQueryTest {

    @Autowired
    EntityManager entityManager;

    @Test
    public void test() {

        CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();

        CriteriaQuery<Course> query = criteriaBuilder.createQuery(Course.class);

        Root<Course> from = query.from(Course.class);

        TypedQuery<Course> typedQuery = this.entityManager.createQuery(query.select(from));

        List<Course> resultList = typedQuery.getResultList();

        resultList.stream().map(course -> course.getName()).forEach(System.out::println);
    }

    @Test
    public void testGetCourseWithSpecific() {

        CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();

        CriteriaQuery<Course> query = criteriaBuilder.createQuery(Course.class);

        Root<Course> from = query.from(Course.class);

        Predicate name = criteriaBuilder.like(from.get("name"), "%100 Steps");

        query.where(name);

        TypedQuery<Course> typedQuery = this.entityManager.createQuery(query.select(from));

        List<Course> resultList = typedQuery.getResultList();

        resultList.stream().map(course -> course.getName()).forEach(System.out::println);
    }

    @Test
    public void testGetCourseWithoutStudent() {

        CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();

        CriteriaQuery<Course> query = criteriaBuilder.createQuery(Course.class);

        Root<Course> from = query.from(Course.class);

        Predicate students = criteriaBuilder.isEmpty(from.get("students"));

        query.where(students);

        TypedQuery<Course> typedQuery = this.entityManager.createQuery(query.select(from));

        List<Course> resultList = typedQuery.getResultList();

        resultList.stream().map(course -> course.getName()).forEach(System.out::println);
    }

    @Test
    public void innerJoinTest() {

        CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();

        CriteriaQuery<Course> query = criteriaBuilder.createQuery(Course.class);

        Root<Course> from = query.from(Course.class);

        from.join("students");

        TypedQuery<Course> typedQuery = this.entityManager.createQuery(query.select(from));

        List<Course> resultList = typedQuery.getResultList();

        resultList.stream().map(course -> course.getName()).forEach(System.out::println);
    }

    @Test
    public void leftJoinTest() {

        CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();

        CriteriaQuery<Course> query = criteriaBuilder.createQuery(Course.class);

        Root<Course> from = query.from(Course.class);

        from.join("students", JoinType.LEFT);

        TypedQuery<Course> typedQuery = this.entityManager.createQuery(query.select(from));

        List<Course> resultList = typedQuery.getResultList();

        resultList.stream().map(course -> course.getName()).forEach(System.out::println);
    }
}
