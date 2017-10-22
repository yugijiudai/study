package com.immoc;

import com.imooc.config.MyJsonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

// import org.mybatis.spring.annotation.MapperScan;

/**
 * @author yugi
 * @apiNote
 * @since 2017-07-07
 */
@SpringBootApplication
@ServletComponentScan
// 扫描该包下相应的class,主要是mybatis的持久化类
// @MapperScan("com.immoc.mapper")
// @MapperScan("com.immoc.*.mapper")
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
        return new HttpMessageConverters(MyJsonConfig.getFastJsonHttpMessageConverter());
    }

    /**
     * 处理跨域
     * @return
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedMethods("PUT", "DELETE", "GET", "POST", "OPTIONS")
                        .allowedHeaders("*")
                        .exposedHeaders("access-control-allow-headers",
                                "access-control-allow-methods",
                                "access-control-allow-origin",
                                "access-control-max-age",
                                "X-Frame-Options")
                        .allowCredentials(false).maxAge(3600);
            }
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
