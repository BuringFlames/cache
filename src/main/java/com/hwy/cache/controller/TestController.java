package com.hwy.cache.controller;

import com.hwy.cache.entity.ResultBean;
import com.hwy.cache.entity.TData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @author hwy
 * @program cache
 * @date 2019/7/11 11:54
 */
@Api(value = "dataService", description = "数据访问测试")
@RestController
@RequestMapping("/api")
public class TestController {


    @ApiOperation(value = "helloService")
    @ApiImplicitParams({
    })
    @RequestMapping("/cache")
    public String helloService() {
        return "hello";
    }

    @ApiOperation(value = "helloService")
    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "id",
                    value = "数据Id",
                    dataType = "Integer",
                    required = true,
                    paramType = "query"
            )
    })
    @GetMapping("/getData")
    public ResultBean getData(@RequestParam("id") int id) {
        ResultBean resultBean = ResultBean.SUCCESS;
        return resultBean;
    }

    @PostMapping("/saveData")
    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "tData",
                    value = "数据实体",
                    dataType = "TData",
                    required = true,
                    paramType = "body"
            )
    })
    public ResultBean saveData(@RequestBody TData tData) {
        return ResultBean.FAILURE;
    }

    @PostMapping("/deleteData")
    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "id",
                    value = "数据Id",
                    dataType = "Integer",
                    required = true,
                    paramType = "query"
            )
    })
    public ResultBean deleteData(@RequestParam("id") int id) {
        return ResultBean.FAILURE;
    }
}
