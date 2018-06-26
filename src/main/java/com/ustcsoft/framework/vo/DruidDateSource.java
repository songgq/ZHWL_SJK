package com.ustcsoft.framework.vo;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.SQLException;

/**
 * Created by Administrator on 2018/3/2.
 */
public class DruidDateSource extends DruidDataSource {

    @Override
    public void init() throws SQLException {

//        System.setProperty("javax.net.ssl.keyStore", "C:/Users/Administrator/Desktop/truststore");
//        System.setProperty("javax.net.ssl.keyStorePassword", "mysqlUSTC%123");
//        System.setProperty("javax.net.ssl.trustStore", "C:/Users/Administrator/Desktop/truststore");
//        System.setProperty("javax.net.ssl.trustStorePassword", "mysqlUSTC%123");
        super.init();
    }

}
