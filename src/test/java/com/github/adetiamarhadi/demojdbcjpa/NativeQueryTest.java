package com.github.adetiamarhadi.demojdbcjpa;

import com.github.adetiamarhadi.demojdbcjpa.entity.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@SpringBootTest
public class NativeQueryTest {

    @Autowired
    EntityManager entityManager;

    @Test
    public void testGetAll() {
        List resultList = entityManager.createNativeQuery("select * from course", Course.class).getResultList();
        System.out.println(resultList);
    }

    @Test
    public void testWithParams() {
        Query nativeQuery = entityManager.createNativeQuery("select * from course where id = ?", Course.class);
        nativeQuery.setParameter(1, 1004L);
        List resultList = nativeQuery.getResultList();
        System.out.println(resultList);
    }

    @Test
    public void testWithNameParams() {
        Query nativeQuery = entityManager.createNativeQuery("select * from course where id = :id", Course.class);
        nativeQuery.setParameter("id", 1004L);
        List resultList = nativeQuery.getResultList();
        System.out.println(resultList);
    }
}
