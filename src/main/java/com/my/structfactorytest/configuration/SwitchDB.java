package com.my.structfactorytest.configuration;

import com.alibaba.druid.pool.DruidDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SwitchDB {
    @Autowired
    private DruidDataSource dataSource;

  public DruidDataSource switchDualDB() {
      if (dataSource == null) {
          System.out.println("数据库链接失败;\n dataSource = :" + dataSource);
      }else {
          System.out.println("数据库连接成功;\n dataSource = :" + dataSource);
      }
      return dataSource;
  }


}
