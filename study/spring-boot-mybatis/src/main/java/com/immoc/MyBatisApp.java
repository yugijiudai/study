package com.immoc;

import com.imooc.config.MyJsonConfig;
import org.springframework.boot.Banner;
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
// 扫描该包下相应的class,主要是mybatis的持久化类,此注解可以不用,因为用了@Mapper就可以了,不用在这里使用,如果这里使用此注解,@Mapper就会无效！
// @MapperScan({"com.immoc.mapper", "com.immoc.dao"})
public class MyBatisApp {


    /**
     * 处理跨域和put,delete等方法的请求,spring5可以使用自定义的CorsConfig来处理
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
        //关掉springboot logo
        // SpringApplication app = new SpringApplication(MyBatisApp.class);
        // app.setBannerMode(Banner.Mode.OFF);
        // app.run(args);
        SpringApplication.run(MyBatisApp.class, args);
    }
}
