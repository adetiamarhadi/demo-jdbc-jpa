package com.github.adetiamarhadi.demojdbcjpa.jpa;

import com.github.adetiamarhadi.demojdbcjpa.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseSpringDataRepository extends JpaRepository<Course, Long> {
}
