package com.tsn.service.impl;

import com.tsn.entity.Role;
import com.tsn.mapper.RoleMapper;
import com.tsn.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tsn
 * @since 2021-07-21
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
