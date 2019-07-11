package com.hwy.cache.controller;

import com.alibaba.fastjson.JSONObject;
import com.hwy.cache.Service.BasicDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hwy
 * @program cache
 * @date 2019/7/11 11:54
 */

@RestController
@RequestMapping("/api")
public class TestController {

    @Autowired
    private BasicDataService basicDataService;

    @RequestMapping("/cache")
    public String helloService() {
        int count = basicDataService.countAllData();

        return "hello";
    }
}
