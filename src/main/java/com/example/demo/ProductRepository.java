package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void save(String name) {
        String sql = "INSERT INTO products (name) VALUES (?)";
        jdbcTemplate.update(sql, name);
    }
}