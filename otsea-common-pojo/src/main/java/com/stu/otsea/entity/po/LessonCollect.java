package com.stu.otsea.entity.po;

import java.io.Serializable;
import java.util.Date;

/**
 * (LessonCollect)实体类
 *
 * @author 乌鸦坐飞机亠
 * @since 2021-01-02 17:44:11
 */
public class LessonCollect implements Serializable {
    private static final long serialVersionUID = -56608557535551612L;
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