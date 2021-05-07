package com.mmdz.service.impl;

import com.mmdz.entity.Blog;
import com.mmdz.mapper.BlogMapper;
import com.mmdz.service.BlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mmdz
 * @since 2021-05-05
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

}
