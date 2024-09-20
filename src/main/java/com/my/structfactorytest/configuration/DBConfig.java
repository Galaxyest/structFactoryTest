//package com.my.structfactorytest.configuration;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import lombok.Data;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.stereotype.Service;
//
//import javax.activation.DataSource;
//
//@Data
//@Configuration
//@Service
////@ConfigurationProperties(prefix = "jdbc")
//public class DBConfig {
//    @Value("${spring.datasource.master.url}")
//    private String masterUrl;
//
//    @Value("${spring.datasource.master.username}")
//    private String username;
//
//    @Value("${spring.datasource.master.password}")
//    private String password;
//
//
//    @Bean
//    public DruidDataSource getDefaultDataSource() {
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setUrl(masterUrl);
//        dataSource.setUsername(username);
//        dataSource.setPassword(password);
//        return dataSource;
//    }
//}
