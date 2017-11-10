package com.immoc.service;

import com.immoc.dao.CityDao;
import com.immoc.pojo.City;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yugi
 * @apiNote
 * @since 2017-07-13
 */
@Service
public class CityService {

    @Resource
    private CityDao cityDao;

    public void saveCity(City city){
        cityDao.saveCity(city);
    }

    public City findCityById(Long id){
        return cityDao.findCityById(id);
    }

    public List<City> getCities() {
        return cityDao.getCities();
    }
}
