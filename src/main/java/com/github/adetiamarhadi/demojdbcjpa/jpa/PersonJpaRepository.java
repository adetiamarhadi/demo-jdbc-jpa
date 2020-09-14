package com.github.adetiamarhadi.demojdbcjpa.jpa;

import com.github.adetiamarhadi.demojdbcjpa.entity.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PersonJpaRepository {

    @PersistenceContext
    EntityManager entityManager;

    public Person findById(int id) {
        return this.entityManager.find(Person.class, id);
    }

    public Person insert(Person person) {
        return this.entityManager.merge(person);
    }

    public Person update(Person person) {
        return this.entityManager.merge(person);
    }
}
