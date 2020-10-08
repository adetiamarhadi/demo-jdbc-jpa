package com.github.adetiamarhadi.demojdbcjpa.jpa;

import com.github.adetiamarhadi.demojdbcjpa.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class EmployeeRepository {

    @Autowired
    EntityManager entityManager;

    public void save(Employee employee) {
        this.entityManager.persist(employee);
    }

    public List<Employee> findAll() {
        return this.entityManager.createQuery("select e from Employee e", Employee.class).getResultList();
    }
}
