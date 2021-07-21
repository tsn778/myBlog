package com.tsn.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tsn.entity.Role;

import java.util.Set;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author tsn
 * @since 2021-07-21
 */
public interface RoleMapper extends BaseMapper<Role> {
    Set<Role> findRolesByUserId(Integer userId);
}
