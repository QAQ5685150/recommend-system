package com.linxx.recommend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author: Linxx
 * @Package: com.linxx.recommend
 * @Time: 2022-10-27 16:09
 * @Description: TODO
 **/
@Configuration
@EnableTransactionManagement(proxyTargetClass=true)
@EnableAutoConfiguration(exclude = {
        DataSourceAutoConfiguration.class
})
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan(basePackages="com.linxx")
@MapperScan(basePackages = {"com.linxx.dao.mapper"})
public class recommendOnlineApplication {

    public static void main(String[] args) {
        SpringApplication.run(recommendOnlineApplication.class,args);
    }
}
