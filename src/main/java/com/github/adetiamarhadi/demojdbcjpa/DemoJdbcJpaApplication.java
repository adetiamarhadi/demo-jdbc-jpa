package com.github.adetiamarhadi.demojdbcjpa;

import com.github.adetiamarhadi.demojdbcjpa.entity.*;
import com.github.adetiamarhadi.demojdbcjpa.jdbc.PersonJdbcDao;
import com.github.adetiamarhadi.demojdbcjpa.jpa.CourseRepository;
import com.github.adetiamarhadi.demojdbcjpa.jpa.EmployeeRepository;
import com.github.adetiamarhadi.demojdbcjpa.jpa.PersonJpaRepository;
import com.github.adetiamarhadi.demojdbcjpa.jpa.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Slf4j
@SpringBootApplication
public class DemoJdbcJpaApplication implements CommandLineRunner {

	@Autowired
	PersonJdbcDao personJdbcDao;

	@Autowired
	PersonJpaRepository personJpaRepository;

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoJdbcJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("jdbc...");
		log.info("{}", this.personJdbcDao.findAll());
		log.info("{}", this.personJdbcDao.findById(1001));
		log.info("{}", this.personJdbcDao.deleteById(1001));
		Person person1002 = Person.builder()
				.id(1002)
				.name("avrillia")
				.location("bekasi")
				.birthDate(new Date())
				.build();
		log.info("{}", this.personJdbcDao.update(person1002));
		Person person1004 = Person.builder()
				.id(1004)
				.name("adetia")
				.location("jakarta")
				.birthDate(new Date())
				.build();
		log.info("{}", this.personJdbcDao.insert(person1004));

		System.out.println("jpa...");
		log.info("{}", this.personJpaRepository.findById(1004));
		Person bambang = Person.builder()
				.name("bambang")
				.location("palembang")
				.birthDate(new Date())
				.build();
		log.info("{}", this.personJpaRepository.insert(bambang));
		Person person1003 = Person.builder()
				.id(1003)
				.name("ani")
				.location("semarang")
				.birthDate(new Date())
				.build();
		log.info("{}", this.personJpaRepository.update(person1003));
		this.personJpaRepository.deleteById(1004);
		log.info("{}", this.personJpaRepository.findById(1004));
		log.info("{}", this.personJpaRepository.findAll());

		log.info("course repository...");
		log.info("{}", this.courseRepository.findById(1004L));
		log.info("{}", this.courseRepository.findById(1005L));
//		this.courseRepository.deleteById(1005L);
		log.info("{}", this.courseRepository.findById(1005L));
		Course angularCourse = Course.builder()
				.name("Udemy - Angular Course")
				.build();
		this.courseRepository.save(angularCourse);
		Course course1004 = this.courseRepository.findById(1004L);
		course1004.setName("updated course");
		Course update = this.courseRepository.update(course1004);
		log.info("{}", update);

		this.courseRepository.playWithEntityManager();
		this.studentRepository.saveStudentWithPasspor();
		List<Review> reviews = Arrays.asList(
				Review.builder()
						.rating(ReviewRating.FIVE)
						.description("elasticsearch's course that makes me a superman!")
						.build(),
				Review.builder()
						.rating(ReviewRating.FIVE)
						.description("this elasticsearch course really amazing!")
						.build()
		);
		this.courseRepository.addReviewsForCourse(1007L, reviews);

		Student student = Student.builder()
				.name("adetia marhadi")
				.build();
		Course course = Course.builder()
				.name("mastering jpa and hibernate in 1000 steps")
				.build();
		this.studentRepository.saveStudentAndCourse(student, course);

		this.employeeRepository.save(new FullTimeEmployee("adet", new BigDecimal("10000")));
		this.employeeRepository.save(new PartTimeEmployee("marhadi", new BigDecimal("50")));
		List<FullTimeEmployee> fullTimeEmployees = this.employeeRepository.findAllFulltimeEmployee();
		List<PartTimeEmployee> partTimeEmployees = this.employeeRepository.findAllPartTimeEmployee();
		log.info("{}", fullTimeEmployees);
		log.info("{}", partTimeEmployees);
	}
}
