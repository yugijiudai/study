package com.immoc.dao;

import com.immoc.pojo.Cat;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author yugi
 * @apiNote
 * @since 2017-07-10
 */
@Repository
public class CatDao {

    @Resource
    private JdbcTemplate jdbcTemplate;


    public Cat findCatByCatName(String catName) {
        String sql = "SELECT * FROM cat WHERE cat_name = ?";
        return this.jdbcTemplate.queryForObject(sql, new Object[]{catName}, new BeanPropertyRowMapper<>(Cat.class));

    }
}
