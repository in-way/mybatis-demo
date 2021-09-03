package com.batis.demo.config;/*
 * @(#) MybatisConfig
 * 版权声明 厦门畅享信息技术有限公司, 版权所有 违者必究
 *
 * <br> Copyright:  Copyright (c) 2020
 * <br> Company:厦门畅享信息技术有限公司
 * <br> @author hanjb
 * <br> 2020-07-20 11:00:18
 */



import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@MapperScan(basePackages = "com.batis.demo.mapper")
public class MyBatisConfig {



    @Bean(name = "mybatisConfiguration")
    @ConfigurationProperties(prefix = "mybatis.configuration")
    public MybatisConfiguration mybatisConfiguration() {
        MybatisConfiguration mybatisConfiguration = new MybatisConfiguration();
        GlobalConfig config = new GlobalConfig();
        GlobalConfig.DbConfig dbConfig = new GlobalConfig.DbConfig();
        dbConfig.setLogicDeleteField("del");
        dbConfig.setLogicDeleteValue("1");
        dbConfig.setLogicNotDeleteValue("0");
        mybatisConfiguration.setGlobalConfig(config.setDbConfig(dbConfig));
        return mybatisConfiguration;
    }

    @Bean
    @Primary
    public DataSourceTransactionManager createTransactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
    //TODO PLUS 要用MybatisSqlSessionFactoryBean 否则BaseBean的方法要失效
    @Bean
    @Primary
    public SqlSessionFactory createSqlSessionFactory(DataSource datasource,
                                                     @Qualifier("mybatisConfiguration") MybatisConfiguration mybatisConfiguration) throws Exception {
        MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
        bean.setDataSource(datasource);
        bean.setConfiguration(mybatisConfiguration);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/**/*.xml"));
        return bean.getObject();
    }

    @Bean
    @Primary
    public SqlSessionTemplate createSqlsessiontemplate(SqlSessionFactory sessionfactory) {
        return new SqlSessionTemplate(sessionfactory);
    }
    /**
     * 分页
     * @author ivy
     * @date 2021/9/2 11:48
     * []
     * com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor
     */
//    @Bean
//    public MybatisPlusInterceptor mybatisPlusInterceptor() {
//        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
//        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
//        Properties properties = new Properties();
//        properties.setProperty("localPage","true");
//        interceptor.setProperties(properties);
//        return interceptor;
//    }
//    @Bean
//    public PaginationInterceptor paginationInterceptor() {
//        PaginationInterceptor page = new PaginationInterceptor();
//        page.setDialectType("mysql");
//        // 打开PageHelper localPage 模式
////        page.setLocalPage(true);
//        return page;
//    }
}
