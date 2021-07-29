package com.tsn.service;

import com.tsn.common.Dto.RouterDto;
import com.tsn.entity.Router;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 路由 服务类
 * </p>
 *
 * @author tsn
 * @since 2021-07-29
 */
public interface RouterService extends IService<Router> {
    List<RouterDto> routers();
}
