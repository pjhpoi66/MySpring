package com.example.demo.test.core.config;


import java.io.IOException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class MybatisConfig {

    private static final int DEFAULT_STATEMENT_TIMEOUT = 30;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private DataSource dataSource;

    @Value("${cagos.datasource.sql-folder}")
    private String sqlFolder;

    @Bean
    public org.apache.ibatis.session.Configuration ibatisConfiguration() {
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        configuration.setDefaultStatementTimeout(DEFAULT_STATEMENT_TIMEOUT);
        return configuration;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {

        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setConfiguration(ibatisConfiguration());

        try {
            Resource[] mapperLocations = applicationContext.getResources("classpath:mapper/" + sqlFolder + "/*.xml");
            Resource[] mapperLocationsTotal = new Resource[mapperLocations.length];
            System.arraycopy(mapperLocations, 0, mapperLocationsTotal, 0, mapperLocations.length);
            sessionFactoryBean.setMapperLocations(mapperLocationsTotal);
        } catch (IOException e1) {
            log.error("not found DB mapper resources");
        }

        return sessionFactoryBean.getObject();
    }

}