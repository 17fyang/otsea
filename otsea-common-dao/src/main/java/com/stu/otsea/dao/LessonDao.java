package com.stu.otsea.dao;

import com.stu.otsea.entity.po.Lesson;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Lesson)表数据库访问层
 *
 * @author 乌鸦坐飞机亠
 * @since 2021-01-03 14:13:00
 */
public interface LessonDao {

    /**
     * 通过ID查询单条数据
     *
     * @param lessonId 主键
     * @return 实例对象
     */
    Lesson queryById(Integer lessonId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Lesson> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param lesson 实例对象
     * @return 对象列表
     */
    List<Lesson> queryAll(Lesson lesson);

    /**
     * 新增数据
     *
     * @param lesson 实例对象
     * @return 影响行数
     */
    int insert(Lesson lesson);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Lesson> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Lesson> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Lesson> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Lesson> entities);

    /**
     * 修改数据
     *
     * @param lesson 实例对象
     * @return 影响行数
     */
    int update(Lesson lesson);

    /**
     * 通过主键删除数据
     *
     * @param lessonId 主键
     * @return 影响行数
     */
    int deleteById(Integer lessonId);

}