package com.tsn.service.impl;

import com.tsn.common.Dto.MetaDto;
import com.tsn.common.Dto.RouterDto;
import com.tsn.entity.Router;
import com.tsn.mapper.RouterMapper;
import com.tsn.service.RouterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 路由 服务实现类
 * </p>
 *
 * @author tsn
 * @since 2021-07-29
 */
@Service
public class RouterServiceImpl extends ServiceImpl<RouterMapper, Router> implements RouterService {
    @Autowired
    private RouterMapper routerMapper;

    @Override
    public List<RouterDto> routers() {
        List<RouterDto> routerDtos = new ArrayList<>();
        List<Router> list = routerMapper.selectList(null);
        for (Router router1 : list) {
            if(router1.getParentId()==0)
                routerDtos.add(getRouter(router1));
        }
        return routerDtos;
    }
    public RouterDto getRouter(Router router) {
        RouterDto routerDto = new RouterDto();

        routerDto.setId(router.getId());
        routerDto.setName(router.getName());
        routerDto.setComponent(router.getComponent());
        routerDto.setPath(router.getPath());
        MetaDto metaDto = new MetaDto();
        metaDto.setIcon(router.getIcon());
        metaDto.setTitle(router.getTitle());
        if(router.getTitle().equals("首页"))
        {
            metaDto.setAffix(true);
        }
        routerDto.setMeta(metaDto);
        List<RouterDto> routerDtos = new ArrayList<>();
        List<Router> list = routerMapper.selectList(null);
        for (Router router1 : list) {
            if (router1.getParentId() == router.getId()) {
                routerDtos.add(getRouter(router1));
            }
//            routerDtos.add(getRouter(router1));
        }
        routerDto.setChildren(routerDtos);
        return routerDto;
    }
}
