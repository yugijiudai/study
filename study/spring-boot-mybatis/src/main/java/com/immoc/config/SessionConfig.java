package com.immoc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author yugi
 * @apiNote redis session共享,用于分布式session共享,在redis中使用keys '*sessions*'查询
 * @since 2017-07-13
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 10)
// @EnableRedisHttpSession(maxInactiveIntervalInSeconds = 86400 * 30)
public class SessionConfig {
}
