package com.tsn.common.Dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author tsn
 * @since 2021/7/29
 */
@Data
public class RouterDto implements Serializable {
    private Integer Id;



    /**
     * 路由路径
     */
    private String path;

    /**
     * 路由网页地址
     */
    private String component;

    /**
     * 路由名称
     */
    private String name;

    /**
     * 重定向
     */
    private String redirect;

    private MetaDto meta;

    private Boolean hidden;

    private List<RouterDto> children;

}
