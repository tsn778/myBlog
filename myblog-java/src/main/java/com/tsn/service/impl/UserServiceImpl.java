package com.tsn.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tsn.common.Result;
import com.tsn.entity.User;
import com.tsn.mapper.UserMapper;
import com.tsn.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tsn
 * @since 2021-07-08
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    UserMapper userMapper;
    @Override
    public Result getUserInfo(String userName) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("user_name",userName);
        User user = userMapper.selectOne(userQueryWrapper);
        if(user==null)
            return Result.failure("验证失败");
        return Result.success("验证成功",user);
    }
}
