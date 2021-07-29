package com.tsn.common.Dto;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author tsn
 * @since 2021/7/29
 */
@Data
public class MetaDto implements Serializable {
    /**
     * 路由名称
     */
    private String title;
    /**
     * 路由图标
     */
    private String icon;
    /**
     * 首页
     */
    private Boolean affix;
}
