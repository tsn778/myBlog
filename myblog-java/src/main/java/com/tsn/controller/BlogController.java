package com.tsn.controller;


import com.tsn.common.Result;
import com.tsn.entity.User;
import com.tsn.service.UserService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tsn
 * @since 2021-07-08
 */
@RestController
@RequestMapping("/tsn/blog")
public class BlogController {
    @Autowired
    private UserService userService;
    @RequiresAuthentication
    @GetMapping("/index")
    public Result index(){
        return Result.success(null);
    }
    @PostMapping("/save")
    public Result save(@Validated  @RequestBody  User user){
//        User user = userService.getById(1);

        return Result.success(user);
    }
}

