package com.tsn.service.impl;

import com.tsn.entity.User;
import com.tsn.mapper.UserMapper;
import com.tsn.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tsn
 * @since 2021-07-06
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
