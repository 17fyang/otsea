package com.stu.otsea.dao;

import com.stu.otsea.entity.Resource;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Resource)表数据库访问层
 *
 * @author 乌鸦坐飞机亠
 * @since 2021-01-03 15:28:55
 */
@Repository
public interface ResourceDao {

    /**
     * 通过ID查询单条数据
     *
     * @param resourceId 主键
     * @return 实例对象
     */
    Resource queryById(Integer resourceId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Resource> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param resource 实例对象
     * @return 对象列表
     */
    List<Resource> queryAll(Resource resource);

    /**
     * 新增数据
     *
     * @param resource 实例对象
     * @return 影响行数
     */
    int insert(Resource resource);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Resource> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Resource> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Resource> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Resource> entities);

    /**
     * 修改数据
     *
     * @param resource 实例对象
     * @return 影响行数
     */
    int update(Resource resource);

    /**
     * 通过主键删除数据
     *
     * @param resourceId 主键
     * @return 影响行数
     */
    int deleteById(Integer resourceId);

}