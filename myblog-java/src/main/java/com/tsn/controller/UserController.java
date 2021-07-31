package com.tsn.controller;


import cn.hutool.core.map.MapUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tsn.common.Dto.LoginDto;
import com.tsn.common.Result;
import com.tsn.entity.User;
import com.tsn.service.UserService;
import com.tsn.util.JwtUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author tsn
 * @since 2021-07-08
 */
@RestController
@RequestMapping("/tsn/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/login")
    public Result login(@Validated @RequestBody LoginDto loginDto, HttpServletResponse response) {
        System.out.println(loginDto);
        User user = userService.getOne(new QueryWrapper<User>().eq("user_name", loginDto.getUserName()));
        Assert.notNull(user, "用户不存在");

        if (!user.getPassword().equals(SecureUtil.md5(loginDto.getPassword()))) {
            return Result.failure("密码不正确");
        }
        String jwt = jwtUtils.generateToken(user.getId());

        response.setHeader("Authorization", jwt);
        response.setHeader("Access-control-Expose-Headers", "Authorization");


        return Result.success(MapUtil.builder()
                .put("id", user.getId())
                .put("username", user.getUserName())
                .put("avatar", user.getAvatar())
                .put("email", user.getEmail())
                .put("token", jwt)
                .map()
        );
    }
    @RequiresAuthentication
    @GetMapping("/getUserInfo")
    public  Result GetUserInfo(@RequestParam("username") String userName){
        System.out.println(userName);
        return userService.getUserInfo(userName);
    }
    @RequiresAuthentication
    @GetMapping("/logout")
    public  Result logout(){
        SecurityUtils.getSubject().logout();
        return Result.success(null);
    }

}

