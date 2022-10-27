package com.linxx.recommend.config.database;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 类名:DataSourceProperties
 * 描述:数据源yml配置属性
 * 姓名:南风
 * 日期:2021-09-14 10:08
 **/
@ConfigurationProperties("spring.datasource")
@Component
public class dataSourceProperties {

    private String url;

    private String userName;

    private String password;

    private String driverClassName;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }
}
