package com.immoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
public class GirlApplication {

    public static void main(String[] args) {
        SpringApplication.run(GirlApplication.class, args);
    }
}
