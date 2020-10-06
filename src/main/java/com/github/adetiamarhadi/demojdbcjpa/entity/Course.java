package com.github.adetiamarhadi.demojdbcjpa.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
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

    @OneToMany(mappedBy = "course")
    private List<Review> reviews = new ArrayList<>();

    @ManyToMany
    private List<Student> students = new ArrayList<>();

    public void addReview(Review review) {
        this.reviews.add(review);
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }
}
