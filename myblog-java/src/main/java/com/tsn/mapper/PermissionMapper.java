package com.tsn.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tsn.entity.Permission;

import java.util.Set;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author tsn
 * @since 2021-07-21
 */
public interface PermissionMapper extends BaseMapper<Permission> {
    Set<Permission> findPermissionByRoleId(Integer roleId);
}
