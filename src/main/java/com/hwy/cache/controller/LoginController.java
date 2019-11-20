package com.hwy.cache.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



/**
 * @author wy.huang
 * @date 2019/11/4 16:23
 */
@Controller
public class LoginController {

    private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("/login")
    public String userSave(String username, String password, Model model) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try{
            subject.login(token);
            model.addAttribute("title", "SpringBoot与Shiro整合");
            LOG.info( "User [" + subject.getPrincipal() + "] logged in successfully." );
            return "/backend";
        }catch (UnknownAccountException e) {
            model.addAttribute("error", e);
            return "/login";
        }catch (IncorrectCredentialsException e1) {
            model.addAttribute("error", e1);
            return "/login";
        }catch (AuthenticationException e2) {
            model.addAttribute("error", e2);
            return "/login";
        }
    }

    @RequestMapping("/index")
    public String index() {
        return "/login1";
    }

    @RequestMapping("/register")
    public String register() {
        return "/register";
    }

    @RequestMapping("/backend")
    public String backend() {
        return "/backend";
    }

    @RequiresPermissions("user:add")
    @RequestMapping("/add")
    public String add() {
        return "/add";
    }

    @RequiresPermissions("user:update")
    @RequestMapping("/update")
    public String update() {
        return "/update";
    }

    @RequestMapping("/noAuth")
    public String noAuth() {
        return "/noAuth";
    }

    @RequiresPermissions("user:delete")
    @RequestMapping("/delete")
    public String delete() {
        return "/delete";
    }

}
