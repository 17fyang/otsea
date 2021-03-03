package com.stu.otsea.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.stu.otsea.entity.po.Lesson;
import org.springframework.stereotype.Repository;

/**
 * (Lesson)表数据库访问层
 *
 * @author 乌鸦坐飞机亠
 * @since 2021-01-03 15:26:03
 */
@Repository
public interface LessonDao extends BaseMapper<Lesson> {


}