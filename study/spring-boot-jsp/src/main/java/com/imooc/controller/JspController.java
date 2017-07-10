package com.imooc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author yugi
 * @apiNote
 * @since 2017-07-10
 */
@Controller
public class JspController {


    @GetMapping(value = "/hello")
    public String index(ModelMap map) {
        map.put("name", "hi");
        return "hello";
    }

}
