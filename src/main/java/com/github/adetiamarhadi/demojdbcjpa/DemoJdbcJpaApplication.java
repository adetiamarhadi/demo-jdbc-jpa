package com.github.adetiamarhadi.demojdbcjpa;

import com.github.adetiamarhadi.demojdbcjpa.entity.Person;
import com.github.adetiamarhadi.demojdbcjpa.jdbc.PersonJdbcDao;
import com.github.adetiamarhadi.demojdbcjpa.jpa.PersonJpaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@Slf4j
@SpringBootApplication
public class DemoJdbcJpaApplication implements CommandLineRunner {

	@Autowired
	PersonJdbcDao personJdbcDao;

	@Autowired
	PersonJpaRepository personJpaRepository;

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
	}
}
