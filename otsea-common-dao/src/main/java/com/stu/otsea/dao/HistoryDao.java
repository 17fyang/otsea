package com.stu.otsea.dao;

import com.stu.otsea.entity.po.History;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (History)表数据库访问层
 *
 * @author 乌鸦坐飞机亠
 * @since 2021-01-02 17:16:24
 */
@Repository
public interface HistoryDao {

    /**
     * 通过ID查询单条数据
     *
     * @param targetId 主键
     * @return 实例对象
     */
    History queryById(Integer targetId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<History> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param history 实例对象
     * @return 对象列表
     */
    List<History> queryAll(History history);

    /**
     * 新增数据
     *
     * @param history 实例对象
     * @return 影响行数
     */
    int insert(History history);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<History> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<History> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<History> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<History> entities);

    /**
     * 修改数据
     *
     * @param history 实例对象
     * @return 影响行数
     */
    int update(History history);

    /**
     * 通过主键删除数据
     *
     * @param targetId 主键
     * @return 影响行数
     */
    int deleteById(Integer targetId);

}