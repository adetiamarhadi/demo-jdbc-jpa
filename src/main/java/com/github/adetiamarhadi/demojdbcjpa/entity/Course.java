package com.github.adetiamarhadi.demojdbcjpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

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
@Cacheable
@SQLDelete(sql = "update course set is_deleted=true where id=?")
@Where(clause = "is_deleted=false")
public class Course {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "course")
    private List<Review> reviews = new ArrayList<>();

    @ManyToMany(mappedBy = "courses")
    @JsonIgnore
    private List<Student> students = new ArrayList<>();

    private boolean isDeleted;

    public void addReview(Review review) {
        this.reviews.add(review);
    }

    public void addStudent(Student student) {
        if (null == this.students) {
            this.students = new ArrayList<>();
        }
        this.students.add(student);
    }
}
