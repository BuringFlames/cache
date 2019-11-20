package com.hwy.cache.service;

import com.hwy.cache.entity.User;
import com.hwy.cache.repository.UserMapper;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author hwy
 * @program cache
 * @date 2019/7/11 18:16
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int saveUser(User user) {
        // 生成随机盐值并使用md5盐值加密
        String salt2 = UUID.randomUUID().toString();
//        ByteSource salt = ByteSource.Util.bytes(uuid);
        String password = new SimpleHash("MD5", user.getPassword(), salt2, 1024)
                .toHex();
        user.setPassword(password);
        user.setSalt(salt2);

        return userMapper.insert(user);
    }

    @Override
    public User getUser(int id) {
        return userMapper.selectByPrimaryKey(id);

    }

    @Override
    public User getUserByName(String name) {
        return userMapper.getUserByName(name);
    }

    @Override
    public int deletedUser(int id) {
        return userMapper.deleteByPrimaryKey(id);
    }

}
