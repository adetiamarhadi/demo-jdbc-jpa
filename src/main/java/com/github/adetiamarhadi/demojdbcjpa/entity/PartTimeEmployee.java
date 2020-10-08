package com.github.adetiamarhadi.demojdbcjpa.entity;

import lombok.ToString;

import javax.persistence.Entity;
import java.math.BigDecimal;

@ToString
@Entity
public class PartTimeEmployee extends Employee {

    private BigDecimal hourlyWage;

    protected PartTimeEmployee(String name, BigDecimal hourlyWage) {
        super(name);
        this.hourlyWage = hourlyWage;
    }

    public BigDecimal getHourlyWage() {
        return hourlyWage;
    }
}
