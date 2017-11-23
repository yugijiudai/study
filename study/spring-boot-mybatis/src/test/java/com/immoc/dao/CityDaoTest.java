package com.immoc.dao;

import com.immoc.pojo.City;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    @Resource
    private RedisTemplate redisTemplate;

    @Test
    public void saveCityTest() throws Exception {
        City city = new City("天朝");
        cityDao.saveCity(city);
        log.info(city.getId());
    }

    @Test
    public void findCityByIdTest() throws Exception {
        City city = cityDao.findCityById(2L);
        // System.out.println(city);
        Set keys = redisTemplate.keys("a*");
        redisTemplate.delete(keys);
        // ValueOperations<String ,City> valueOperations = redisTemplate.opsForValue();
        // valueOperations.set("a1", city);
        // valueOperations.set("a2", city);
        // valueOperations.set("a3", city);
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        List<String> list2 = new ArrayList<>();
        list2.add("5");
        list2.add("2");
        list2.add("3");
        List<String> collect = list.stream().flatMap((Function<String, Stream<String>>) li -> list2.stream().filter(li::equals)).collect(Collectors.toList());
        System.out.println(collect);
    }

}