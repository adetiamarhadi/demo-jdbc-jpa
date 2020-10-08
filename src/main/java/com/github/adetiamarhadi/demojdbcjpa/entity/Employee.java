package com.github.adetiamarhadi.demojdbcjpa.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Employee {

    @Id
    @GeneratedValue
    protected Long id;

    @Column(nullable = false)
    protected String name;

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
