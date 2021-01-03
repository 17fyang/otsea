package com.stu.otsea.dao;

import com.stu.otsea.entity.LessonCollect;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (LessonCollect)表数据库访问层
 *
 * @author 乌鸦坐飞机亠
 * @since 2021-01-03 15:45:01
 */
public interface LessonCollectDao {

    /**
     * 通过USER ID查找多条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    List<LessonCollect> queryListByUserId(String userId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<LessonCollect> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param lessonCollect 实例对象
     * @return 对象列表
     */
    List<LessonCollect> queryAll(LessonCollect lessonCollect);

    /**
     * 新增数据
     *
     * @param lessonCollect 实例对象
     * @return 影响行数
     */
    int insert(LessonCollect lessonCollect);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<LessonCollect> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<LessonCollect> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<LessonCollect> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<LessonCollect> entities);

    /**
     * 修改数据
     *
     * @param lessonCollect 实例对象
     * @return 影响行数
     */
    int update(LessonCollect lessonCollect);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 影响行数
     */
    int deleteById(String userId, Integer lessonId);

}