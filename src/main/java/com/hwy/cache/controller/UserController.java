package com.hwy.cache.controller;

import com.hwy.cache.service.UserService;
import com.hwy.cache.config.redis.RedisConfig;
import com.hwy.cache.entity.ResultBean;
import com.hwy.cache.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author hwy
 * @program cache
 * @date 2019/7/12 17:36
 */

@Controller
@RequestMapping("/user")
@Api(value = "用户控制器")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    RedisConfig redisConfig;

    @ApiOperation("创建用户")
    @ApiImplicitParams({
            @ApiImplicitParam(
                    name="id",
                    value = "用户id",
                    type = "Integer",
                    required = true
            )
    })
    @RequestMapping("/userCreate")
    public String userSave(String username, String password) {
        User user  = new User();
        user.setUsername(username);
        user.setPassword(password);
        if(userService.saveUser(user) == 1) {
            return "/login";
        }else{
            return "/error";
        }
    }

    @ApiOperation("查询用户")
    @ApiImplicitParams({
            @ApiImplicitParam(
                    name="user",
                    value = "用户",
                    type = "User",
                    required = true
            )
    })
    @RequestMapping("/getUser")
    @ResponseBody
    public ResultBean getUser(int id) {
        User user = userService.getUser(id);
        ResultBean resultBean = ResultBean.SUCCESS;
        resultBean.setData(user);

        return resultBean;
    }



}
