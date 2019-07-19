package com.hwy.cache.Service;

import com.hwy.cache.cache.CacheManager;
import com.hwy.cache.entity.User;
import com.hwy.cache.entity.vo.UserEntry;
import com.hwy.cache.repository.UserMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hwy
 * @program cache
 * @date 2019/7/11 18:16
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public int saveUser(User user){
        return userMapper.insert(user);
    }

    @Override
    public User getUser(int id) {
        CacheManager cacheManager = new CacheManager();
        UserEntry userEntry = cacheManager.getUser(id);
        if(userEntry != null) {
            User user = new User();
            BeanUtils.copyProperties(userEntry, user);
            return user;
        }
        return userMapper.selectByPrimaryKey(id);

    }

    @Override
    public int deletedUser(int id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userMapper.selectAllUsers();
    }
}
