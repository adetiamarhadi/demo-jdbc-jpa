package com.github.adetiamarhadi.demojdbcjpa.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Person {
    private int id;
    private String name;
    private String location;
    private Date birthDate;
}
