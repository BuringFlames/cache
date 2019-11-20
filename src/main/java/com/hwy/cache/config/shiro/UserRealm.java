package com.hwy.cache.config.shiro;

import com.hwy.cache.entity.User;
import com.hwy.cache.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author wy.huang
 * @date 2019/11/4 16:33
 */
@Component
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //授权
        SimpleAuthorizationInfo simpleAuthenticationInfo = new SimpleAuthorizationInfo();
        Subject subject = SecurityUtils.getSubject();
        User user = (User)subject.getPrincipal();
        User dbUser = userService.getUser(user.getId());
        // 添加角色
        simpleAuthenticationInfo.addRole(dbUser.getRole());

        // 添加授权字符串
        simpleAuthenticationInfo.addStringPermissions(Arrays.asList(dbUser.getPerms().split(",")));
        return simpleAuthenticationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        User user = userService.getUserByName(username);

        if (user == null) {
            return null;
        }

        ByteSource salt = ByteSource.Util.bytes(user.getSalt());
        return new SimpleAuthenticationInfo(user, user.getPassword(), salt, getName());
    }

    //设置盐解析，这里要和生成盐的设置相同，使用MD5，解密次数1次
    @Override
    public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
        //HashedCredentialsMatcher是shiro提供的解析盐的实现类
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName("MD5");
        matcher.setHashIterations(1024);
        super.setCredentialsMatcher(matcher);
    }

}
