package com.immoc.service;

import com.immoc.pojo.Girl;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * @author yugi
 * @apiNote
 * @since 2017-06-30
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {

    @Resource
    private GirlService girlService;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void insertTwoTest() throws Exception {
    }

    @Test
    public void getAgeTest() throws Exception {
    }

    @Test
    public void findOneTest() throws Exception {
        Girl one = girlService.findOne(4);
        assertEquals(new Integer(8), one.getAge());
    }

}