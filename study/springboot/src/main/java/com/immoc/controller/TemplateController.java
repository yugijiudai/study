package com.immoc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @author yugi
 * @apiNote 注意:在Thymeleaf模板文件中,标签是需要闭合的
 * @since 2017-07-10
 */
@Controller
@RequestMapping(value = "/templates")
public class TemplateController {

    /**
     * 映射地址是:/templates/hello
     */
    @GetMapping(value = "/hello")
    public String hello(Map<String, Object> map) {
        map.put("name", "the world!");
        return "hello";
    }

    @GetMapping(value = "/helloFtl")
    public String helloFtl(Map<String, Object> map) {
        map.put("name", "star Platinum!");
        return "helloFtl";
    }

}
