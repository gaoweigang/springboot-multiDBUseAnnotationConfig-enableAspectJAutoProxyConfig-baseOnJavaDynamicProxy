package com.gwg.shiro.web.config.jdbc;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 配置多数据源
 * @author gwg
 */
@Configuration
public class DynamicDataSourceConfig {


    @Bean
    @ConfigurationProperties("spring.datasource.user")
    public DataSource userDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.role")
    public DataSource roleDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    @DependsOn({"userDataSource","roleDataSource"})
    public DynamicDataSource dataSource(DataSource userDataSource, DataSource roleDataSource) {
        Map<String, DataSource> targetDataSources = new HashMap<>();
        targetDataSources.put(DataSourceNames.USER, userDataSource);
        targetDataSources.put(DataSourceNames.ROLE, roleDataSource);
        return new DynamicDataSource(userDataSource, targetDataSources);
    }


}
