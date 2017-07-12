package com.immoc.controller;

import com.github.pagehelper.PageHelper;
import com.immoc.pojo.Demo;
import com.immoc.service.DemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yugi
 * @apiNote
 * @since 2017-07-12
 */
@RestController
public class DemoController {

    @Resource
    private DemoService demoService;


    @GetMapping(value = "/getDemo/{name}")
    public List<Demo> getDemo(@PathVariable("name") String name) {
        //第一个参数:第几页,第二个参数：每页获取多少条
        PageHelper.startPage(1, 2);
        return demoService.getByName(name);
    }

    @PostMapping(value = "/saveDemo")
    public Demo saveDemo(Demo demo) {
        demoService.saveDemo(demo);
        return demo;
    }
}
