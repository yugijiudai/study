package com.immoc.dao;

import com.immoc.pojo.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author yugi
 * @apiNote {@code <Girl, Integer>的Integer是id类型}
 * @since 2017-06-27
 */
public interface GirlRepository extends JpaRepository<Girl, Integer> {

    /**
     * 通过年龄查询
     */
    List<Girl> findByAgeBeforeAndAgeAfter(Integer before, Integer after);
}
