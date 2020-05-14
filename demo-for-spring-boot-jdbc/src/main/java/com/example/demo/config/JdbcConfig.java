package com.example.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author <a href="https://www.songfang.top"> ZhSMM </a>
 * @date 2020/05/13
 * @description 数据源的JDBC配置类
 **/
//@Configuration
// 加载指定的配置文件
//@PropertySource(name = "dataSource", value = "classpath:/config/jdbc.properties", ignoreResourceNotFound = false)
//@EnableConfigurationProperties(JdbcProperties.class) // 指定加载哪个配置信息属性类
//public class JdbcConfig {
    //@Autowired
//    private JdbcProperties jdbcProperties;
//
//    public JdbcConfig(JdbcProperties jdbcProperties){
//        this.jdbcProperties = jdbcProperties;
//    }

    /**
     * 实例化Druid
     */
//    @Bean
//    public DataSource getDataSource() {
//        DruidDataSource source = new DruidDataSource();
//        source.setPassword(jdbcProperties.getPassword());
//        source.setUsername(this.jdbcProperties.getUsername());
//        source.setDriverClassName(this.jdbcProperties.getDriverClassName());
//        source.setUrl(this.jdbcProperties.getUrl());
//        return source;
//    }
//    @Bean
//    @ConfigurationProperties(prefix = "jdbc")
//    public DataSource getDataSource() {
//        DruidDataSource source = new DruidDataSource();
//        return source;
//    }
//}
