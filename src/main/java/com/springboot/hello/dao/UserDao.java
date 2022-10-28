package com.springboot.hello.dao;

import com.springboot.hello.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDao {
    private final JdbcTemplate jdbcTemplate;
    private final DataSource dataSource;

    public UserDao(JdbcTemplate jdbcTemplate, DataSource dataSource) {
        this.jdbcTemplate = jdbcTemplate;
        this.dataSource = dataSource;
    }

    RowMapper<User> rowMapper = new RowMapper<User>() {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User(rs.getString("id"), rs.getString("name"),
                    rs.getString("password"));
            return user;
        }
    };

    public void add(User user){
        this.jdbcTemplate.update("insert users(id,name,password) values(?,?,?)",
                user.getId(),user.getName(),user.getPassword());
    }
    public User select(String id) {
        String sql = "Select * from user where id = ?";
        return this.jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    public void deleteAll(){
        this.jdbcTemplate.update("delete from users");
    }

    public void deleteById(String id){
        this.jdbcTemplate.update("delete * from users where id=?;",id);
    }

}
