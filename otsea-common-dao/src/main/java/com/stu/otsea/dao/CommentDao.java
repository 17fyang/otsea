package com.stu.otsea.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.stu.otsea.entity.po.Comment;
import org.springframework.stereotype.Repository;

/**
 * (Comment)表数据库访问层
 *
 * @author 乌鸦坐飞机亠
 * @since 2021-01-03 15:25:57
 */
@Repository
public interface CommentDao extends BaseMapper<Comment> {

}