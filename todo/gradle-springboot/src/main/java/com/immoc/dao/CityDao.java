package com.immoc.dao;

import com.immoc.pojo.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yugi
 * @apiNote
 * @since 2017-07-12
 */
// @Repository
@Mapper
public interface CityDao {

    void saveCity(City city);

    City findCityById(Long id);

    List<City> findCityListByName(@Param("name") String name);
}
