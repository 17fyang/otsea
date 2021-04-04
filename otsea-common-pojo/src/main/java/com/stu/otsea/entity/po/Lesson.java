package com.stu.otsea.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.Date;

/**
 * (Lesson)实体类
 *
 * @author 乌鸦坐飞机亠
 * @since 2021-01-03 15:26:36
 */
public class Lesson implements Serializable {
    private static final long serialVersionUID = -48131736502617128L;
    /**
     * 课程id，自增主键
     */
    @TableId(type = IdType.AUTO)
    private Integer lessonId;
    /**
     * 用户作者id，对应mongo object id
     */
    private String authorId;
    /**
     * 课程标题
     */
    private String title;
    /**
     * 课程介绍
     */
    private String introduce;
    /**
     * 展示图片id
     */
    private Integer titleImageId;
    /**
     * 课程文档结构，json格式
     */
    private String folderStructure;
    /**
     * 创建时间
     */
    private Date createTime;


    public Integer getLessonId() {
        return lessonId;
    }

    public void setLessonId(Integer lessonId) {
        this.lessonId = lessonId;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public Integer getTitleImageId() {
        return titleImageId;
    }

    public void setTitleImageId(Integer titleImageId) {
        this.titleImageId = titleImageId;
    }

    public String getFolderStructure() {
        return folderStructure;
    }

    public void setFolderStructure(String folderStructure) {
        this.folderStructure = folderStructure;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}