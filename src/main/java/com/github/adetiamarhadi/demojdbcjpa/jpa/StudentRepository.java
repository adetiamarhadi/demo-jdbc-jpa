package com.github.adetiamarhadi.demojdbcjpa.jpa;

import com.github.adetiamarhadi.demojdbcjpa.entity.Passport;
import com.github.adetiamarhadi.demojdbcjpa.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional
public class StudentRepository {

    @Autowired
    EntityManager entityManager;

    public Student findById(Long id) {
        return this.entityManager.find(Student.class, id);
    }

    public void deleteById(Long id) {
        Student student = findById(id);
        this.entityManager.remove(student);
    }

    public void save(Student student) {
        this.entityManager.persist(student);
    }

    public Student update(Student student) {
        return this.entityManager.merge(student);
    }

    public void saveStudentWithPasspor() {

        Passport passport = Passport.builder()
                .number("Z209182")
                .build();
        entityManager.persist(passport);

        Student student = Student.builder()
                .name("Mike")
                .passport(passport)
                .build();
        entityManager.persist(student);
    }
}
