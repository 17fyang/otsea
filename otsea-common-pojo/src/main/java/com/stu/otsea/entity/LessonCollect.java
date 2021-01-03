package com.stu.otsea.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (LessonCollect)实体类
 *
 * @author 乌鸦坐飞机亠
 * @since 2021-01-03 15:26:36
 */
public class LessonCollect implements Serializable {
    private static final long serialVersionUID = -32997435574742705L;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 课程id
     */
    private Integer lessonId;
    /**
     * 创建时间
     */
    private Date createTime;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getLessonId() {
        return lessonId;
    }

    public void setLessonId(Integer lessonId) {
        this.lessonId = lessonId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}