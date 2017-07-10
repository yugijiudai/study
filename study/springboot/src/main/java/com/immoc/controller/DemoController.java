package com.immoc.controller;

import com.immoc.pojo.Cat;
import com.immoc.service.CatService;
import com.immoc.vo.DemoVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author yugi
 * @apiNote
 * @since 2017-07-07
 */
@RestController
public class DemoController {

    @Resource
    private CatService catService;


    @GetMapping(value = "/getDemo")
    public DemoVo getDemo() {
        return new DemoVo(1, "栗子", new Date(), LocalDateTime.now(), "这是备注");
    }

    @GetMapping(value = "/getDemo2")
    public DemoVo getDemo2() {
        return new DemoVo(2, "栗子2", new Date(), LocalDateTime.now(), "这是备注2");
    }


    @GetMapping(value = "/{catName}/getCat")
    public Cat getCat(@PathVariable("catName") String catName){
        return catService.findCatByCatName(catName);
    }

}
