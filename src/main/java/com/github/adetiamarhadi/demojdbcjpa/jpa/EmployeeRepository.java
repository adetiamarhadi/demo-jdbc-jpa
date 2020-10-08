package com.github.adetiamarhadi.demojdbcjpa.jpa;

import com.github.adetiamarhadi.demojdbcjpa.entity.Employee;
import com.github.adetiamarhadi.demojdbcjpa.entity.FullTimeEmployee;
import com.github.adetiamarhadi.demojdbcjpa.entity.PartTimeEmployee;
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

    public List<FullTimeEmployee> findAllFulltimeEmployee() {
        return this.entityManager.createQuery("select e from FullTimeEmployee e",
                FullTimeEmployee.class).getResultList();
    }

    public List<PartTimeEmployee> findAllPartTimeEmployee() {
        return this.entityManager.createQuery("select e from PartTimeEmployee e",
                PartTimeEmployee.class).getResultList();
    }
}
