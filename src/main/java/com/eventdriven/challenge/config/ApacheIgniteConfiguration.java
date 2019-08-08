package com.eventdriven.challenge.config;

import com.datastax.driver.core.policies.RoundRobinPolicy;
import com.eventdriven.challenge.domain.ClickEvent;
import com.eventdriven.challenge.domain.ViewEvent;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteException;
import org.apache.ignite.Ignition;
import org.apache.ignite.cache.CacheAtomicityMode;
import org.apache.ignite.cache.store.cassandra.datasource.DataSource;
import org.apache.ignite.configuration.*;
import org.apache.ignite.springdata20.repository.config.EnableIgniteRepositories;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
@EnableIgniteRepositories(basePackages="com.eventdriven.challenge.repositories.cache")
public class ApacheIgniteConfiguration {
    private static final String INSTANCE_NAME = "challenge-cache";
    private static Logger logger = LoggerFactory.getLogger(ApacheIgniteConfiguration.class.getName());

    @Bean
    public IgniteConfiguration igniteCfg() {
        IgniteConfiguration cfg = new IgniteConfiguration();
        // Setting some custom name for the node.
        cfg.setIgniteInstanceName(INSTANCE_NAME);

        // Enabling peer-class loading feature.
        cfg.setPeerClassLoadingEnabled(true);

        DataSource dataSource = new DataSource();
        dataSource.setContactPoints("127.0.0.1");
        RoundRobinPolicy robinPolicy = new RoundRobinPolicy();
        dataSource.setLoadBalancingPolicy(robinPolicy);
        dataSource.setReadConsistency("ONE");
        dataSource.setWriteConsistency("ONE");

        // Defining and creating a new cache to be used by Ignite Spring Data
        // repository.
        CacheConfiguration clickCache = new CacheConfiguration("ClickEventCache");
        // Setting SQL schema for the cache.
        clickCache.setIndexedTypes(Long.class, ClickEvent.class);

        CacheConfiguration viewCache = new CacheConfiguration("ViewEventCache");
        viewCache.setIndexedTypes(Long.class, ViewEvent.class);

        cfg.setCacheConfiguration(clickCache, viewCache);

        return cfg;
    }

    @Bean(destroyMethod = "close")
    public Ignite igniteInstance(IgniteConfiguration igniteConfiguration) throws IgniteException {
        logger.info("Ignite Starting ...");
//        Ignite ignite  = Ignition.start("apacheignite-cassandra.xml");
//        ignite.cache("ClickEventCache").loadCache(null);
//		ignite.cache("ViewEventCache").loadCache(null);
//        return ignite;
        return Ignition.start(igniteConfiguration);
    }
}