package com.tsn.service.impl;

import com.tsn.entity.UserRole;
import com.tsn.mapper.UserRoleMapper;
import com.tsn.service.UserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色表 服务实现类
 * </p>
 *
 * @author tsn
 * @since 2021-07-21
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

}
