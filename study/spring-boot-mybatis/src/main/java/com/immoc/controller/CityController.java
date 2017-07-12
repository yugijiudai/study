package com.immoc.controller;

import com.immoc.pojo.City;
import com.immoc.service.CityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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

}
