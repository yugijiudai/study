package com.immoc.mapper;

import com.immoc.pojo.Demo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yugi
 * @apiNote
 * @since 2017-07-11
 */
@Mapper
@Repository
public interface DemoMapper {

    @Select("select * from demo where name LIKE CONCAT(CONCAT('%', #{name}), '%')")
    List<Demo> getByName(String name);

    @Select("select id,name from demo where id = #{id}")
    Demo getById(Long id);


    //Options注解可以获得自增主键
    @Insert("insert into demo (name) values(#{name})")
    @Options(useGeneratedKeys = true, keyColumn = "id")
        // @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void saveDemo(Demo demo);


}
