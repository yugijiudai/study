package com.immoc.service;

import com.immoc.pojo.Demo;
import com.immoc.service.DemoService;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author yugi
 * @apiNote
 * @since 2017-07-12
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Log4j2
public class DemoServiceTest {


    @Resource
    private DemoService demoService;

    @Test
    public void insertDemoTest() throws Exception {
        Demo demo = new Demo("龟爷");
        demoService.saveDemo(demo);
    }

    @Test
    public void getById(){
        Demo demo = demoService.getById(1L);
        log.warn(demo);
    }

}