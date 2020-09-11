package com.github.adetiamarhadi.demojdbcjpa;

import com.github.adetiamarhadi.demojdbcjpa.jdbc.PersonJdbcDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class DemoJdbcJpaApplication implements CommandLineRunner {

	@Autowired
	PersonJdbcDao personJdbcDao;

	public static void main(String[] args) {
		SpringApplication.run(DemoJdbcJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("{}", this.personJdbcDao.findAll());
	}
}
