package com.immoc.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author yugi
 * @apiNote
 * @since 2017-11-23
 */
@ConfigurationProperties(prefix = "druid")
@Component
@Data
public class RedisProperties {

    @Value("${redisson.url}")
    private String redissonUrl;


    @Value("${redisson.password}")
    private String redissonPassword;


    @Value("${spring.redis.timeout}")
    private Integer timeout;


    @Value("${redisson.connectionPoolSize}")
    private Integer connectionPoolSize;


    @Value("${redisson.connectionMinimumIdleSize}")
    private Integer connectionMinimumIdleSize;




}
