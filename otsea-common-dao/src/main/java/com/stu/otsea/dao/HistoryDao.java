package com.stu.otsea.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.stu.otsea.entity.po.History;
import org.springframework.stereotype.Repository;

/**
 * (History)表数据库访问层
 *
 * @author 乌鸦坐飞机亠
 * @since 2021-01-03 15:26:00
 */
@Repository
public interface HistoryDao extends BaseMapper<History> {


}