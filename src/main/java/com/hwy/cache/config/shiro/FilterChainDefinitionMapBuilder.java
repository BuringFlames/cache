package com.hwy.cache.config.shiro;

import com.hwy.cache.entity.Permission;
import com.hwy.cache.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author wy.huang
 * @date 2019/11/15 14:57
 */
@Component
public class FilterChainDefinitionMapBuilder {

    @Autowired
    private PermissionService permissionService;

    public LinkedHashMap<String, String> buildFilterChainDefinitionMap() {
        LinkedHashMap<String, String> hashMap = new LinkedHashMap<>();
        List<Permission> list = permissionService.getAllPermissions();
        for (Permission permission : list) {
            hashMap.put(permission.getUrl(), permission.getPermession());
        }
        return hashMap;
    }
}
