package com.boss.train.bes.common.transaction.example.configuration;

import com.boss.train.bes.common.transaction.configuration.DataSourceProxyAutoConfiguration;
import io.seata.rm.datasource.DataSourceProxy;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import(DataSourceProxyAutoConfiguration.class)
@MapperScan(basePackages = "com.boss.train.bes.common.transaction.example.dao")
@Configuration
public class RootConfig {

    @Autowired
    public DataSourceProxy dataSource;

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean vueServerSessionFactory = new SqlSessionFactoryBean();
        vueServerSessionFactory.setDataSource(dataSource);
        return vueServerSessionFactory.getObject();
    }
}
