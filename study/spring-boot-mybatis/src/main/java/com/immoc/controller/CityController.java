package com.immoc.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.immoc.pojo.City;
import com.immoc.service.CityService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;

/**
 * @author yugi
 * @apiNote
 * @since 2017-07-13
 */
@RestController
public class CityController {

    @Resource
    private CityService cityService;

    @GetMapping(value = "/findCity/{id}")
    public City findCity(@PathVariable("id") Long id) {
        return cityService.findCityById(id);
    }

    @GetMapping(value = "/getCities")
    public Object getCities() {
        Page<City> page = PageHelper.startPage(1, 2);
        cityService.getCities();
        return page.toPageInfo();
    }

}
