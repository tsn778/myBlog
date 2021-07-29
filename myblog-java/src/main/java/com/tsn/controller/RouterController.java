package com.tsn.controller;


import com.tsn.common.Result;
import com.tsn.service.RouterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 路由 前端控制器
 * </p>
 *
 * @author tsn
 * @since 2021-07-29
 */
@RestController
@RequestMapping("/tsn/router")
public class RouterController {
    @Autowired
    private RouterService routerService;
    @GetMapping("/getRouter")
    public Result getRouter(){
        return Result.success("查询成功",routerService.routers());
    }

}

