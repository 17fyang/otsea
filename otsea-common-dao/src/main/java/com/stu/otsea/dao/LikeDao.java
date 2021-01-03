package com.stu.otsea.dao;

import com.stu.otsea.entity.Like;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Like)表数据库访问层
 *
 * @author 乌鸦坐飞机亠
 * @since 2021-01-03 15:26:08
 */
@Repository
public interface LikeDao {

    /**
     * 通过ID查询单条数据
     *
     * @param targetId 主键
     * @return 实例对象
     */
    Like queryById(Integer targetId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Like> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param like 实例对象
     * @return 对象列表
     */
    List<Like> queryAll(Like like);

    /**
     * 新增数据
     *
     * @param like 实例对象
     * @return 影响行数
     */
    int insert(Like like);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Like> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Like> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Like> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Like> entities);

    /**
     * 修改数据
     *
     * @param like 实例对象
     * @return 影响行数
     */
    int update(Like like);

    /**
     * 通过主键删除数据
     *
     * @param targetId 主键
     * @return 影响行数
     */
    int deleteById(Integer targetId);

}