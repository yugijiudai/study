package com.immoc.service;

import com.immoc.pojo.Cat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;

/**
 * @author yugi
 * @apiNote
 * @since 2017-07-08
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CatServiceTest {

    @Inject
    private CatService catService;

    @Test
    public void findMyCatName() throws Exception {
        Cat cat = catService.findCatByQuery("蓝猫");
        System.out.println(cat);
    }

    @Test
    public void findByCatNameTest() throws Exception {
        Cat cat = catService.findByCatName("蓝猫");
        System.out.println(cat);
    }

}