package com.github.adetiamarhadi.demojdbcjpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "pelajar")
public class Student {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "nama", nullable = false)
    private String name;
}
