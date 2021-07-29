package com.tsn.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 路由
 * </p>
 *
 * @author tsn
 * @since 2021-07-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Router implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "Id", type = IdType.AUTO)
    private Integer Id;

    /**
     * 路由名称
     */
    private String title;

    /**
     * 路由路径
     */
    private String path;

    /**
     * 路由网页地址
     */
    private String component;

    /**
     * 重定向
     */
    private String redirect;
    /**
     * 路由名称
     */
    private String name;

    /**
     * 路由图标
     */
    private String icon;

    /**
     * 首页
     */
    private String affix;

    /**
     * 父子关系
     */
    private Integer parentId;

    /**
     * 权限
     */
    private String permission;


}
