package com.immoc;

import org.springframework.boot.SpringApplication;

/**
 * @author yugi
 * @apiNote
 * @since 2017-06-23
 */
// @ComponentScan
// SpringBootApplication没配置，默认扫描当前包下的所有类 springboot下启动类只能出现一个
// @SpringBootApplication
// ServletComponentScan要加上，不然DruidStatViewServlet会找不到404
// @ServletComponentScan
public class GirlApplication {

    public static void main(String[] args) {
        SpringApplication.run(GirlApplication.class, args);
    }
}
