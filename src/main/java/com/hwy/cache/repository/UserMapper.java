package com.hwy.cache.repository;

import com.hwy.cache.entity.User;
import com.hwy.cache.entity.UserExample;
import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    User getUserByName(String username);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}