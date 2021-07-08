package com.tsn.service.impl;

import com.tsn.entity.Blog;
import com.tsn.mapper.BlogMapper;
import com.tsn.service.BlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tsn
 * @since 2021-07-08
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

}
