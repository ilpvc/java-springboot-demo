package com.example.cachetest.config;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.transaction.managed.ManagedTransactionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Description:
 *
 * @date:2023/6/25 20:39
 * @author: ilpvc
 */

@Configuration
public class MybatisPlusConfig {

//    @Bean
//    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
//
//        MybatisSqlSessionFactoryBean factoryBean = new MybatisSqlSessionFactoryBean();
//        factoryBean.setDataSource(dataSource);
//        return factoryBean.getObject();
//    }
}
