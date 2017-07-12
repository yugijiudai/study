package com.immoc;

import com.imooc.config.MyJsonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;

// import org.mybatis.spring.annotation.MapperScan;

/**
 * @author yugi
 * @apiNote
 * @since 2017-07-07
 */
@SpringBootApplication
@ServletComponentScan
// 扫描该包下相应的class,主要是mybatis的持久化类,此注解可以不用,因为用了@Mapper就可以了,不用在这里使用,如果这里使用此注解,@Mapper就会无效！
// @MapperScan({"com.immoc.mapper", "com.immoc.dao"})
public class MyBatisApp {


    /**
     * 在这里我们使用@Bean注入HttpMessageConverter
     */
    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        return new HttpMessageConverters(MyJsonConfig.getFastJsonHttpMessageConverter());
    }


    public static void main(String[] args) {
        SpringApplication.run(MyBatisApp.class, args);
    }
}