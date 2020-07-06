package com.boss.xtrain.common.transaction.config;

import com.alibaba.druid.pool.DruidDataSource;
import io.seata.rm.datasource.DataSourceProxy;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
/**
 * @description 数据源配置类
 *
 * <br> 设置DataSourceProxy，以实现分布式事务的控制
 *
 * @author lzx
 * @data 2020.07.03
 */
@Configuration
public class DataSourceProxyConfig {

    /**
     * 配置数据源代理，用于事务回滚
     *
     * @return 返回datasource
     * @see DataSourceProxy
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DruidDataSource druidDataSource() {
        return new DruidDataSource();
    }

    /**
     * 初始化 DataSourceProxy
     *
     * @param druidDataSource druidDataSource实例，代理对数据源的访问
     * @return  DataSourceProxy
     */
    @Bean
    public DataSourceProxy dataSourceProxy(DruidDataSource druidDataSource) {
        return new DataSourceProxy(druidDataSource);
    }

    @Bean
    public DataSourceTransactionManager transactionManager(DataSourceProxy dataSourceProxy) {
        return new DataSourceTransactionManager(dataSourceProxy);
    }

}