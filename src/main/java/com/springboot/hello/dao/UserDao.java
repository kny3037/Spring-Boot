package com.springboot.hello.dao;

import com.springboot.hello.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class UserDao {
    private final JdbcTemplate jdbcTemplate;
    private final DataSource dataSource;

    public UserDao(JdbcTemplate jdbcTemplate, DataSource dataSource) {
        this.jdbcTemplate = jdbcTemplate;
        this.dataSource = dataSource;
    }

    public void add(User user){
        this.jdbcTemplate.update("insert users(id,name,password) values(?,?,?)",
                user.getId(),user.getName(),user.getPassword());
    }

    public int deleteAll(){
        return this.jdbcTemplate.update("delete from users");
    }
}
