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
import org.apache.ignite.spi.discovery.tcp.TcpDiscoverySpi;
import org.apache.ignite.spi.discovery.tcp.ipfinder.multicast.TcpDiscoveryMulticastIpFinder;
import org.apache.ignite.springdata20.repository.config.EnableIgniteRepositories;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@EnableIgniteRepositories(basePackages="com.eventdriven.challenge.repositories.cache")
public class ApacheIgniteConfiguration {

    private static Logger logger = LoggerFactory.getLogger(ApacheIgniteConfiguration.class.getName());

    @Value("${ignite.instanceName}")
    private String INSTANCE_NAME;
    @Value("${ignite.cassandraContactPoint}")
    private String CASSANDRA_CONTACT_POINT;
    @Value("${ignite.ipFinderRange}")
    private String IP_FINDER_RANGE;

    @Bean
    public IgniteConfiguration igniteCfg() {
        IgniteConfiguration cfg = new IgniteConfiguration();

        // Setting some custom name for the node.
        cfg.setIgniteInstanceName(INSTANCE_NAME);

        // Enabling peer-class loading feature.
        cfg.setPeerClassLoadingEnabled(true);

        DataSource dataSource = new DataSource();
        dataSource.setContactPoints(CASSANDRA_CONTACT_POINT);
        RoundRobinPolicy robinPolicy = new RoundRobinPolicy();
        dataSource.setLoadBalancingPolicy(robinPolicy);
        dataSource.setReadConsistency("ONE");
        dataSource.setWriteConsistency("ONE");

        // Network cluster discovery
        List<String> ipRange = new ArrayList<>();
        ipRange.add(IP_FINDER_RANGE);
        TcpDiscoverySpi spi = new TcpDiscoverySpi();
        TcpDiscoveryMulticastIpFinder ipFinder = new TcpDiscoveryMulticastIpFinder();
        ipFinder.setAddresses(ipRange);
        spi.setIpFinder(ipFinder);

        // Defining and creating a new cache to be used by Ignite Spring Data
        // repository.
        CacheConfiguration clickCache = new CacheConfiguration("ClickEventCache");
        CacheConfiguration viewCache = new CacheConfiguration("ViewEventCache");

        // Setting SQL schema for the cache.
        clickCache.setIndexedTypes(Long.class, ClickEvent.class);
        viewCache.setIndexedTypes(Long.class, ViewEvent.class);

        // Setting AtomicityMode
        clickCache.setAtomicityMode(CacheAtomicityMode.ATOMIC);
        viewCache.setAtomicityMode(CacheAtomicityMode.ATOMIC);

        cfg.setCacheConfiguration(clickCache, viewCache);
        cfg.setDiscoverySpi(spi);

        return cfg;
    }

    @Bean(destroyMethod = "close")
    public Ignite igniteInstance(IgniteConfiguration igniteConfiguration) throws IgniteException {
        return Ignition.start(igniteConfiguration);
    }
}