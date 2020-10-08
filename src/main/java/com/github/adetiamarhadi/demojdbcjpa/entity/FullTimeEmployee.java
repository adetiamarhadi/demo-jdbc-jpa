package com.github.adetiamarhadi.demojdbcjpa.entity;

import lombok.ToString;

import javax.persistence.Entity;
import java.math.BigDecimal;

@ToString
@Entity
public class FullTimeEmployee extends Employee {

    private BigDecimal salary;

    protected FullTimeEmployee(String name, BigDecimal salary) {
        super(name);
        this.salary = salary;
    }

    public BigDecimal getSalary() {
        return salary;
    }
}
