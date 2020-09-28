package com.github.adetiamarhadi.demojdbcjpa.jpa;

import com.github.adetiamarhadi.demojdbcjpa.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;

@Slf4j
@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    EntityManager entityManager;

    @Test
    public void retrieveStudentAndPassportDetails() {

        Student student = entityManager.find(Student.class, 200001);
        log.info("student -> {}", student);
        log.info("passport -> {}", student.getPassport());
    }
}