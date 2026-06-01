package com.app.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "com.app")
@PropertySource("classpath:database.properties")
public class AppConfig {

    @Autowired
    private Environment env; 
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();

        ds.setDriverClassName(env.getProperty("jdbc.driver"));
        ds.setUrl(env.getProperty("jdbc.url"));
        ds.setUsername(env.getProperty("jdbc.user"));
        ds.setPassword(env.getProperty("jdbc.password"));

        return ds;
    }

    private Properties hibernateProperties() {
        Properties props = new Properties();

        props.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
        props.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));

        return props;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean factory = new LocalSessionFactoryBean();

        factory.setDataSource(dataSource());
        factory.setPackagesToScan("com.app.entity");
        factory.setHibernateProperties(hibernateProperties());

        return factory;
    }
    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager txManager = new HibernateTransactionManager();

        txManager.setSessionFactory(sessionFactory);

        return txManager;
    }
}