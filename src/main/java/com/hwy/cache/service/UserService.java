package com.hwy.cache.service;

import com.hwy.cache.entity.User;

import java.util.List;

/**
 * @author hwy
 * @program cache
 * @date 2019/7/11 18:14
 */
public interface UserService {

    int saveUser(User user);

    User getUser(int id);

    User getUserByName(String name);

    int deletedUser(int id);

}
