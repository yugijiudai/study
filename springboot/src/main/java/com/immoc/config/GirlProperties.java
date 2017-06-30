package com.immoc.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author yugi
 * @apiNote
 * @since 2017-06-26
 */
@ConfigurationProperties(prefix = "girl")
@Component
@Data
public class GirlProperties {

    private String cupSize;

    private Integer age;

}
