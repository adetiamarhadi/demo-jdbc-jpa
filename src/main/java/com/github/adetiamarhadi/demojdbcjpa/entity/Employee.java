package com.github.adetiamarhadi.demojdbcjpa.entity;

import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@ToString
@Entity
public abstract class Employee {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    protected Employee(String name) {
        this.name = name;
    }

    protected Long getId() {
        return id;
    }

    protected String getName() {
        return name;
    }
}
