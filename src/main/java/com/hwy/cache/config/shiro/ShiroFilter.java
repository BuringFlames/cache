package com.hwy.cache.config.shiro;

import com.hwy.cache.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author wy.huang
 * @date 2019/11/8 16:51
 */
public class ShiroFilter extends BasicHttpAuthenticationFilter {
    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(ShiroFilter.class);
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if (null != user && isLoginRequest(request,response)){
            return true;
        }
        return false;
    }

}
