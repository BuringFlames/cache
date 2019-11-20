package com.hwy.cache.config.redis;

import com.hwy.cache.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author hwy
 * @program cache
 * @date 2019/7/19 21:01
 */

@Configuration
public class RedisConfig {
    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(RedisConfig.class);

    @Value("${redis.host}")
    private String host;

    @Value("${redis.port}")
    private int port;

    @Value("${redis.password}")
    private String password;

    @Value("${redis.pool.max-active}")
    private int maxActive;

    @Value("${redis.pool.max-wait}")
    private int maxWait;

    @Value("${redis.pool.max-idle}")
    private int maxIdle;

    @Value("${redis.pool.min-idle}")
    private int minIdle;

    @Bean
    public JedisPool redisPoolFactory() {
        try {
            JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
            jedisPoolConfig.setMaxIdle(maxIdle);
            jedisPoolConfig.setMaxWaitMillis(maxWait);
            jedisPoolConfig.setMaxTotal(maxActive);
            jedisPoolConfig.setMinIdle(minIdle);
            String pwd = StringUtil.isBlank(password) ? null : password;
            JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port, 3000, pwd);
            logger.info("初始化Redis连接池JedisPool成功!地址: " + host + ":" + port);
            return jedisPool;
        } catch (Exception e) {
            logger.error("初始化Redis连接池JedisPool异常:" + e.getMessage());
        }
        return null;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMaxActive() {
        return maxActive;
    }

    public void setMaxActive(int maxActive) {
        this.maxActive = maxActive;
    }

    public int getMaxWait() {
        return maxWait;
    }

    public void setMaxWait(int maxWait) {
        this.maxWait = maxWait;
    }

    public int getMaxIdle() {
        return maxIdle;
    }

    public void setMaxIdle(int maxIdle) {
        this.maxIdle = maxIdle;
    }

    public int getMinIdle() {
        return minIdle;
    }

    public void setMinIdle(int minIdle) {
        this.minIdle = minIdle;
    }
}
