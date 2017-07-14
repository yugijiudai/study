package com.immoc.config;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @author yugi
 * @apiNote
 * @since 2017-06-30
 */
@Configuration
@Log4j2
public class DruidDBConfig {

    @Resource
    private DBConfig dbConfig;


    @Bean     //声明其为Bean实例
    @Primary  //在同样的DataSource中，首先使用被标注的DataSource
    public DataSource dataSource() {
        DruidDataSource datasource = new DruidDataSource();
        try {
            BeanUtils.copyProperties(datasource, dbConfig);
        }
        catch (Exception e) {
            log.error("druid configuration initialization filter", e);
        }
        return datasource;
    }

}