package com.hwy.cache.config;

import com.hwy.cache.Service.UserService;
import com.hwy.cache.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * @author hwy
 * @program cache
 * @date 2019/7/19 21:01
 */

@Configuration
public class RedisConfig {

    private String ip;
    private int port;

    @Autowired
    private UserService userService;

    public User test() {
        return userService.getUser(1);
    }

}
