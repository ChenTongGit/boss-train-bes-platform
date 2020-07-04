package com.boss.train.bes.common.transaction.configuration;

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
 * <br> 设置jdbc链接信息，以构造函数的方式注入DataSourceProperties
 *
 * @author lzx
 * @data 2020.07.03
 */
@Configuration
public class DataSourceProxyAutoConfiguration {

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
     * @param druidDataSource druidDataSource实例
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