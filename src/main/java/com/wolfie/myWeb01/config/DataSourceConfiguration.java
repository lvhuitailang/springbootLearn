package com.wolfie.myWeb01.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
@PropertySource(value = {"classpath:jdbc.properties"})
public class DataSourceConfiguration {

    @Value("${jdbc.url}")
    private String jdbcUrl;
    @Value("${jdbc.driver}")
    private String jdbcDriverClassName;
    @Value("${jdbc.username}")
    private String userName;
    @Value("${jdbc.password}")
    private String passWord;
    @Value("${c3p0.pool.maxPoolSize}")
    private int maxPoolSize;
    @Value("${c3p0.pool.minPoolSize}")
    private int minPoolSize;
    @Value("${c3p0.pool.initialPoolSize}")
    private int initialPoolSize;
    @Value("${c3p0.pool.acquireIncrement}")
    private int acquireIncrement;


    @Bean
    public DataSource dataSource() throws PropertyVetoException {
        //使用c3p0数据库连接池
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        //数据库驱动
        comboPooledDataSource.setDriverClass(jdbcDriverClassName);
        //数据库连接地址
        comboPooledDataSource.setJdbcUrl(jdbcUrl);
        //数据库用户名
        comboPooledDataSource.setUser(userName);
        //数据库密码
        comboPooledDataSource.setPassword(passWord);
        //连接池中保留的最大连接数。默认为15
        comboPooledDataSource.setMaxPoolSize(maxPoolSize);
        //连接池中保留的最小连接数。默认为15
        comboPooledDataSource.setMinPoolSize(minPoolSize);
        //初始化时创建的连接数，应在minPoolSize与maxPoolSize之间取值。默认为3
        comboPooledDataSource.setInitialPoolSize(initialPoolSize);
        //定义在从数据库获取新连接失败后重复尝试获取的次数，默认为30
        comboPooledDataSource.setAcquireIncrement(acquireIncrement);
        return comboPooledDataSource;
    }
    
}
