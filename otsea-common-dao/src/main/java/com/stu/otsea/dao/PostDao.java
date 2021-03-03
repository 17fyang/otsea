package com.stu.otsea.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.stu.otsea.entity.po.Post;
import org.springframework.stereotype.Repository;

/**
 * (Post)表数据库访问层
 *
 * @author 乌鸦坐飞机亠
 * @since 2021-01-03 15:26:10
 */
@Repository
public interface PostDao extends BaseMapper<Post> {

}