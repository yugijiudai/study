package com.immoc.config;

import com.imooc.config.MyJsonConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;


/**
 * @author zhonghaowen
 * @apiNote 使用了@JsonFormat的优先
 * @since 2017-12-11
 */
@EnableWebMvc
@Configuration
public class JsonConfig extends WebMvcConfigurerAdapter {


    //添加转换器
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        //将我们定义的时间格式转换器添加到转换器列表中,
        //这样jackson格式化时候但凡遇到Date类型就会转换成我们定义的格式
        converters.add(MyJsonConfig.getJackson2Date());
        converters.add(MyJsonConfig.getFastJsonHttpMessageConverter());
    }
}

