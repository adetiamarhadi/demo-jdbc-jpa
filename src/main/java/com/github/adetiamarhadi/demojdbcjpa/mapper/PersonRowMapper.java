package com.github.adetiamarhadi.demojdbcjpa.mapper;

import com.github.adetiamarhadi.demojdbcjpa.entity.Person;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonRowMapper implements RowMapper<Person> {

    @Override
    public Person mapRow(ResultSet resultSet, int i) throws SQLException {
        return Person.builder()
                .id(resultSet.getInt("id"))
                .name(resultSet.getString("name"))
                .location(resultSet.getString("location"))
                .birthDate(resultSet.getTimestamp("birth_date"))
                .build();
    }
}
