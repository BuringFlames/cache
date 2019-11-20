package com.hwy.cache.service;

import com.hwy.cache.entity.Permission;
import com.hwy.cache.repository.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wy.huang
 * @date 2019/11/18 11:26
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<Permission> getAllPermissions() {
        return permissionMapper.selectAll();
    }
}
