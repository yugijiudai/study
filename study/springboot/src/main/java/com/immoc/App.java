package com.immoc;

import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;

import static com.alibaba.fastjson.serializer.SerializerFeature.PrettyFormat;

/**
 * @author yugi
 * @apiNote
 * @since 2017-07-07
 */
@SpringBootApplication
@ServletComponentScan
public class App {
// public class App extends WebMvcConfigurerAdapter {


    /**
     * 通过继承WebMvcConfigurerAdapter，重写这方法来控制返回页面的类型格式
     *
     * @param converters
     */
   /* @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        // 1.需要先定义一个convert 转换消息的对象;
        FastJsonHttpMessageConverter fastConvert = new FastJsonHttpMessageConverter();
        // 2.添加fastJson的配置信息,比如:是否要格式化返回的json数据;
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(PrettyFormat);
        // 3.在convert中添加配置信息
        fastConvert.setFastJsonConfig(fastJsonConfig);
        // 4.将convert添加到converters当中
        converters.add(fastConvert);
    }*/

    /**
     * 在这里我们使用@Bean注入HttpMessageConverter
     */
    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        FastJsonHttpMessageConverter fastConvert = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(PrettyFormat);
        fastConvert.setFastJsonConfig(fastJsonConfig);
        return new HttpMessageConverters(fastConvert);
    }


    public static void main(String[] args) {
        // System.out.println(LocalDateTime.now());

        SpringApplication.run(App.class, args);
    }
}
