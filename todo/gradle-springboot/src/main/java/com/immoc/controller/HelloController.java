package com.immoc.controller;

import com.github.pagehelper.PageHelper;
import com.immoc.dao.CityDao;
import com.immoc.pojo.City;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yugi
 * @apiNote
 * @since 2017-07-14
 */
@RestController
public class HelloController {

    @Resource
    private CityDao cityDao;


    @GetMapping(value = "/{name}/sayHello")
    public List<City> sayHello(@PathVariable("name") String name) {
        PageHelper.startPage(1, 1);
        // PageHelper.offsetPage(1,1);
        List<City> list = cityDao.findCityListByName(name);
        System.out.println(list);
        return list;
    }

    @PostMapping(value = "/saveCity")
    public City saveCity(@RequestBody City city){
        cityDao.saveCity(city);
        return city;
    }
}
