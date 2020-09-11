package com.github.adetiamarhadi.demojdbcjpa.jdbc;

import com.github.adetiamarhadi.demojdbcjpa.entity.Person;
import com.github.adetiamarhadi.demojdbcjpa.mapper.PersonRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class PersonJdbcDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Person> findAll() {
        return this.jdbcTemplate.query("select * from person", new PersonRowMapper());
    }

    public Person findById(int id) {
        return this.jdbcTemplate.queryForObject("select * from person where id=?", new Object[] {id},
                new BeanPropertyRowMapper<>(Person.class));
    }

    public int deleteById(int id) {
        return this.jdbcTemplate.update("delete from person where id=?", new Object[] {id});
    }

    public int insert(Person person) {
        return this.jdbcTemplate.update("insert into person (id, name, location, birth_date) values (?, ?, ?, ?)",
                new Object[] {person.getId(), person.getName(), person.getLocation(),
                        new Timestamp(person.getBirthDate().getTime())});
    }

    public int update(Person person) {
        return this.jdbcTemplate.update("update person set name=?, location=?, birth_date=? where id=?",
                new Object[] {person.getName(), person.getLocation(), new Timestamp(person.getBirthDate().getTime()),
                        person.getId()});
    }
}
