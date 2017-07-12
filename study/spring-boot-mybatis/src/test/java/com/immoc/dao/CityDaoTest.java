package com.immoc.dao;

import com.immoc.pojo.City;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * @author yugi
 * @apiNote
 * @since 2017-07-12
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Log4j2
// @MybatisTest
public class CityDaoTest {

    @Resource
    private CityDao cityDao;

    @Test
    public void saveCityTest() throws Exception {
        City city = new City("天朝");
        cityDao.saveCity(city);
        log.info(city.getId());
    }

    @Test
    public void findCityByIdTest() throws Exception {
        System.out.println(cityDao.findCityById(2L));
    }

}