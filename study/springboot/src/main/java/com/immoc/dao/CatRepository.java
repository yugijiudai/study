package com.immoc.dao;

import com.immoc.pojo.Cat;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import javax.inject.Named;

/**
 * @author yugi
 * @apiNote
 * @since 2017-07-08
 */
@Named
public interface CatRepository extends Repository<Cat, Integer> {

    /**
     * 查询方法以get|find|read开头
     * 涉及查询条件时,条件的属性用条件关键字连接,要注意的是条件属性以首字母大写
     */

    Cat findByCatName(String catName);

    /**
     * 如何编写JPQL语句
     * Hibernate --HQL语句
     * JPQL语句和HQL语句是类似的
     */


    @Query(value = "select cat from Cat cat where cat.catName =:cn")
    Cat findCatByQuery(@Param("cn") String name);

}
