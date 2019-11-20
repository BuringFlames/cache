package com.hwy.cache.config.shiro;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

/**
 * @author wy.huang
 * @date 2019/11/6 17:49
 */
@Configuration
public class ShiroConfig {

    @Autowired
    FilterChainDefinitionMapBuilder filterChainDefinitionMapBuilder;

    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        // 使用自定义Realm
        defaultWebSecurityManager.setRealm(userRealm);
        // 关闭Shiro自带的session
        DefaultSubjectDAO subjectDAO = new DefaultSubjectDAO();
        DefaultSessionStorageEvaluator defaultSessionStorageEvaluator = new DefaultSessionStorageEvaluator();
        defaultSessionStorageEvaluator.setSessionStorageEnabled(false);
        subjectDAO.setSessionStorageEvaluator(defaultSessionStorageEvaluator);
        defaultWebSecurityManager.setSubjectDAO(subjectDAO);
//        // 设置自定义Cache缓存
//        defaultWebSecurityManager.setCacheManager(new CustomCacheManager());
        return defaultWebSecurityManager;
    }


    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
//        Map<String, Filter> filterMap = new HashMap<>(16);
//        filterMap.put("shiroFilter",new ShiroFilter());
//        shiroFilterFactoryBean.setFilters(filterMap);
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 自定义url规则使用LinkedHashMap有序Map
        LinkedHashMap<String, String> filterChainDefinitionMap = filterChainDefinitionMapBuilder.buildFilterChainDefinitionMap();
//        filterChainDefinitionMap.put("/login", "anon");
//        filterChainDefinitionMap.put("/index", "anon");
//        filterChainDefinitionMap.put("/register", "anon");
//        filterChainDefinitionMap.put("/backend", "authc");
//        filterChainDefinitionMap.put("/add", "perms[user:add]");
//        filterChainDefinitionMap.put("/update", "perms[user:update]");
//        filterChainDefinitionMap.put("/delete", "perms[user:delete]");
        filterChainDefinitionMap.put("/*", "authc");

        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setUnauthorizedUrl("/noAuth");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

//    /**
//     * 密码匹配凭证管理器
//     *
//     * @return
//     */
//    @Bean(name = "credentialsMatcher")
//    public HashedCredentialsMatcher hashedCredentialsMatcher() {
//        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
//        // 采用MD5方式加密
//        hashedCredentialsMatcher.setHashAlgorithmName("MD5");
//        // 设置加密次数
//        hashedCredentialsMatcher.setHashIterations(1024);
//        return hashedCredentialsMatcher;
//    }

    /**
     * 配置ShiroDialect，用于Shiro和thymeleaf标签配合使用
     * @return
     */
    @Bean
    public ShiroDialect shiroDialect(){
        return new ShiroDialect();
    }


}
