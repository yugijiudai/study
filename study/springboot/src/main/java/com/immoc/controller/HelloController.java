package com.immoc.controller;

import com.immoc.config.GirlProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author yugi
 * @apiNote RestController相当于Controller和ResponseBody
 * @since 2017-06-24
 */

@RestController
// @Controller
@RequestMapping("/hello")
public class HelloController {


/*    //region 不用这种注释
    @Value("${cupSize}")
    private String cupSize;

    @Value("${content}")
    private String content;
    //endregion*/

    @Resource
    private GirlProperties girlProperties;


    @RequestMapping(value = {"/say", "/hi"}, method = RequestMethod.GET)
    public String say() {
        // return "index";
        return girlProperties.toString();
    }

    // @RequestMapping(value = {"/{id}/say"}, method = RequestMethod.GET)
    @GetMapping(value = "/{id}/say")
    // @PostMapping(value = "/{id}/say")
    public String say2(@PathVariable("id") Integer id, @RequestParam(value = "myId", required = false, defaultValue = "0") String myId) {
        System.out.println("sss");
        return id + ":" + myId;
    }
}
