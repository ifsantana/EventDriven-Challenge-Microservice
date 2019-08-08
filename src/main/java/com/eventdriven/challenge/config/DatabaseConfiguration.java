package com.eventdriven.challenge.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

//@Configuration
//@EnableJpaRepositories(basePackages = {"com.eventdriven.challenge.repositories"})
public class DatabaseConfiguration {

//    @Value("${spring.db.hibernate.auto}")
//    private String hibernateAuto;
//
//    @Primary
//    @Bean(name = "dataSource")
//    @ConfigurationProperties(prefix="spring.db.datasource")
//    public DataSource dataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Value("${spring.jpa.database-platform}")
//    private String hibernateDialect;
//
//    @Primary
//    @Bean(name = "entityManagerFactory")
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
//            EntityManagerFactoryBuilder builder,
//            @Qualifier("dataSource") DataSource dataSource) {
//
//        Map<String, Object> properties = new HashMap<>();
//        properties.put("hibernate.dialect", hibernateDialect);
//        properties.put("hibernate.hbm2ddl.auto", hibernateAuto);
//
//        return builder
//                .dataSource(dataSource)
//                .packages("com.eventdriven.challenge.domain")
//                .properties(properties)
//                .build();
//    }
//
//    @Primary
//    @Bean(name = "transactionManager")
//    public PlatformTransactionManager transactionManager(
//            @Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory) {
//        return new JpaTransactionManager(entityManagerFactory);
//    }

}
