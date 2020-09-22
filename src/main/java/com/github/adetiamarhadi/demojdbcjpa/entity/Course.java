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
@NamedQueries(value = {
        @NamedQuery(name = "get_all_course", query = "select c from Course c"),
        @NamedQuery(name = "get_all_100_steps_course", query = "select c from Course c where name like '%100 steps'")
})
public class Course {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
}
