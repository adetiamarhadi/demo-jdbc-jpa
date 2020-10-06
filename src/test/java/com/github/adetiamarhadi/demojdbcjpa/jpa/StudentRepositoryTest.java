package com.github.adetiamarhadi.demojdbcjpa.jpa;

import com.github.adetiamarhadi.demojdbcjpa.entity.Passport;
import com.github.adetiamarhadi.demojdbcjpa.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Slf4j
@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    public void testSaveAndUpdate() {
        studentRepository.saveAndUpdate();
    }

    @Test
    @Transactional
    public void retrieveStudentAndPassportDetails() {

        Student student = entityManager.find(Student.class, 200001);
        log.info("student -> {}", student);
        log.info("passport -> {}", student.getPassport());
    }

    @Test
    @Transactional
    public void retrievePassportAndStudentDetails() {

        Passport passport = entityManager.find(Passport.class, 300001);
        log.info("passport -> {}", passport);
        log.info("student -> {}", passport.getStudent());
    }

    @Test
    @Transactional
    public void getStudentAndCourse() {
        Student student = this.entityManager.find(Student.class, 200001);
        System.out.println(student.getName());
        student.getCourses().forEach(c -> System.out.println(c.getName()));
    }
}