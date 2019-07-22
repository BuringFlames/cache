package com.hwy.cache.controller;

import com.hwy.cache.Service.UserService;
import com.hwy.cache.config.RedisConfig;
import com.hwy.cache.entity.ResultBean;
import com.hwy.cache.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hwy
 * @program cache
 * @date 2019/7/12 17:36
 */

@RestController
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
    @RequestMapping("/userSave")
    public ResultBean userSave(@RequestBody User user) {
        if(userService.saveUser(user) == 1) {
            return ResultBean.SUCCESS;
        }else{
            return ResultBean.FAILURE;
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
    public ResultBean getUser(int id) {
        User user = userService.getUser(id);
        ResultBean resultBean = ResultBean.SUCCESS;
        resultBean.setData(user);

        return resultBean;
    }



}
