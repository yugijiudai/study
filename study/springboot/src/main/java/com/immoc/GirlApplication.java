package com.immoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author yugi
 * @apiNote
 * @since 2017-06-23
 */
// SpringBootApplication没配置，默认扫描当前包下的所有类
@SpringBootApplication
// @EnableAutoConfiguration
// @ComponentScan
// @Configuration
// ServletComponentScan要加上，不然DruidStatViewServlet会找不到404
@ServletComponentScan
public class GirlApplication {

    public static void main(String[] args) {
        SpringApplication.run(GirlApplication.class, args);
    }
}
