package com.stu.otsea.dao;


import com.stu.otsea.entity.po.VideoPost;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (VideoPost)表数据库访问层
 *
 * @author 乌鸦坐飞机亠
 * @since 2021-01-02 18:12:52
 */
public interface VideoPostDao {

    /**
     * 通过ID查询单条数据
     *
     * @param videoId 主键
     * @return 实例对象
     */
    VideoPost queryById(Integer videoId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<VideoPost> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param videoPost 实例对象
     * @return 对象列表
     */
    List<VideoPost> queryAll(VideoPost videoPost);

    /**
     * 新增数据
     *
     * @param videoPost 实例对象
     * @return 影响行数
     */
    int insert(VideoPost videoPost);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<VideoPost> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<VideoPost> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<VideoPost> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<VideoPost> entities);

    /**
     * 修改数据
     *
     * @param videoPost 实例对象
     * @return 影响行数
     */
    int update(VideoPost videoPost);

    /**
     * 通过主键删除数据
     *
     * @param videoId 主键
     * @return 影响行数
     */
    int deleteById(Integer videoId);

}