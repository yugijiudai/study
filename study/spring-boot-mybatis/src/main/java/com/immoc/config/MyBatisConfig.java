package com.immoc.config;

import com.github.pagehelper.PageHelper;

import java.util.Properties;

/**
 * @author yugi
 * @apiNote pageHelper换成5.0.0这个类就不需要了, 但要多依赖一个pagehelper-spring-boot-starter
 * @since 2017-07-12
 */
// @Configuration
public class MyBatisConfig {


    // @Bean
    public PageHelper pageHelper() {
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("offsetAsPageNum", "true");
        properties.setProperty("rowBoundsWithCount", "true");
        properties.setProperty("reasonable", "true");
        pageHelper.setProperties(properties);
        return pageHelper;
    }
}
