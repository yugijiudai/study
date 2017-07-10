package com.immoc.service;

import com.immoc.dao.CatDao;
import com.immoc.dao.CatRepository;
import com.immoc.pojo.Cat;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author yugi
 * @apiNote
 * @since 2017-07-08
 */
@Named
public class CatService {

    @Inject
    private CatRepository catRepository;

    @Resource
    private CatDao catDao;


    public Cat findByCatName(String catName) {
        return catRepository.findByCatName(catName);
    }

    public Cat findCatByQuery(String name) {
        return catRepository.findCatByQuery(name);
    }


    public Cat findCatByCatName(String catName){
        return catDao.findCatByCatName(catName);
    }
}
