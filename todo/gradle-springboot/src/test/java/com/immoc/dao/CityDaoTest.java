package com.immoc.dao;

import com.immoc.pojo.City;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author yugi
 * @apiNote
 * @since 2017-07-14
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class CityDaoTest {

    @Resource
    private CityDao cityDao;


    @Test
    public void findCityByIdTest() throws Exception {
        City cityById = cityDao.findCityById(1L);
        System.out.println(cityById);
    }

}