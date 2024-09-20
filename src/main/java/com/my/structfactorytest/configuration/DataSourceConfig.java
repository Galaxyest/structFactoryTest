//package com.my.structfactorytest.configuration;
//
//import com.alibaba.druid.pool.DruidDataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//
//import javax.activation.DataSource;
//import javax.annotation.Resource;
//
//@Configuration
//public class DataSourceConfig {
//    @Autowired
//    private Environment env;
//
//
//    @Bean
//    public DruidDataSource getDataSource() {
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setUrl(env.getProperty("spring.datasource.master.url"));
//        dataSource.setUsername(env.getProperty("spring.datasource.master.username"));
//        dataSource.setPassword(env.getProperty("spring.datasource.master.password"));
//        return  dataSource;
//    }
//}
