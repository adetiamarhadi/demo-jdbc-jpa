package com.github.adetiamarhadi.demojdbcjpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Review {

    @Id
    @GeneratedValue
    private int id;

    private String rating;
    private String description;
}
