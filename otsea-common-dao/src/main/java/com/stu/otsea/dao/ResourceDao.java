package com.stu.otsea.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.stu.otsea.entity.po.Resource;
import org.springframework.stereotype.Repository;

/**
 * (Resource)表数据库访问层
 *
 * @author 乌鸦坐飞机亠
 * @since 2021-01-03 15:28:55
 */
@Repository
public interface ResourceDao extends BaseMapper<Resource> {


}