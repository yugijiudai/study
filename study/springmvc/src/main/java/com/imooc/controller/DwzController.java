package com.imooc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author yugi
 * @apiNote
 * @since 2017-08-31
 */
@Controller
public class DwzController {


    @GetMapping(value = "welLogin")
    String login(){
        return "login";
    }

    @PostMapping(value = "dwzDoLogin")
    String dwzDoLogin(){
        return "index";
    }
}
