package com.stock.service.config;

import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableCaching
public class CacheConfiguration {

    private final Logger log = LoggerFactory.getLogger(CacheConfiguration.class);

    private net.sf.ehcache.CacheManager cacheManager;

    @PreDestroy
    public void destroy() {
        this.cacheManager.shutdown();
    }

    @Bean
    public CacheManager cacheManager() {
        this.log.debug("Starting Ehcache");
        this.cacheManager = net.sf.ehcache.CacheManager.create();
        this.cacheManager.getConfiguration()
                .setMaxBytesLocalHeap("16M");
        this.log.debug("Registering Ehcache Metrics gauges");
        EhCacheCacheManager ehCacheManager = new EhCacheCacheManager();
        ehCacheManager.setCacheManager(this.cacheManager);
        return ehCacheManager;
    }
}

