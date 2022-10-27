package com.linxx.recommend.config.database;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * 类名:DtatSourceConfiguration
 * 描述:数据源配置类
 * 姓名:南风
 * 日期:2021-09-14 10:13
 **/
@Configuration
@MapperScan(
        sqlSessionFactoryRef = "sqlSessionFactory" )
public class dataSourceConfiguration {

    @Resource
    private dataSourceProperties dataSourceProperties;

    @Resource
    private connectionPoolProperties poolProperties;

    @Bean
    public DataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(dataSourceProperties.getDriverClassName());
        dataSource.setUrl(dataSourceProperties.getUrl());
        dataSource.setUsername(dataSourceProperties.getUserName());
        dataSource.setPassword(dataSourceProperties.getPassword());
        configDataSourceConnectPool(dataSource);
        return dataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(final DataSource baseDataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(baseDataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        factoryBean.setMapperLocations(
                resolver.getResources("classpath*:mapper/**/**.xml"));
        return factoryBean.getObject();
    }

    @Bean(name = "transactionManager")
    public DataSourceTransactionManager flightTransactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    private void configDataSourceConnectPool(DruidDataSource dataSource){
        //configuration
        dataSource.setInitialSize(poolProperties.getInitialSize());
        dataSource.setMinIdle(poolProperties.getMinIdle());
        dataSource.setMaxActive(poolProperties.getMaxActive());
        dataSource.setMaxWait(poolProperties.getMaxWait());
        dataSource.setTimeBetweenEvictionRunsMillis(poolProperties.getTimeBetweenEvictionRunsMillis());
        dataSource.setMinEvictableIdleTimeMillis(poolProperties.getMinEvictableIdleTimeMillis());
        dataSource.setValidationQuery(poolProperties.getValidationQuery());
        dataSource.setTestWhileIdle(poolProperties.isTestWhileIdle());
        dataSource.setTestOnBorrow(poolProperties.isTestOnBorrow());
        dataSource.setTestOnReturn(poolProperties.isTestOnReturn());
        dataSource.setPoolPreparedStatements(poolProperties.isPoolPreparedStatements());
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(poolProperties.getMaxPoolPreparedStatementPerConnectionSize());
    }

}
