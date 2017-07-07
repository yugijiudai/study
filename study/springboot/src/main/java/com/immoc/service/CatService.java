package com.immoc.service;

import com.immoc.dao.CatRepository;
import com.immoc.pojo.Cat;

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


    public Cat findByCatName(String catName) {
        return catRepository.findByCatName(catName);
    }

    public Cat findCatByQuery(String name) {
        return catRepository.findCatByQuery(name);
    }
}
