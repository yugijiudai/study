package com.imooc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author yugi
 * @apiNote
 * @since 2017-07-10
 */
@SpringBootApplication
@ServletComponentScan
public class JspApp {


    public static void main(String[] args) {
        SpringApplication.run(JspApp.class, args);
    }
}
