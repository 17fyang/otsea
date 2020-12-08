package com.stu.otsea.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (Comment)实体类
 *
 * @author 乌鸦坐飞机亠
 * @since 2020-12-07 14:54:31
 */
public class Comment implements Serializable {
    private static final long serialVersionUID = 565048009582919453L;
    /**
     * 资源id
     */
    private Integer targetId;
    /**
     * 资源类型，0：帖子，1：课程
     */
    private Object targetType;
    /**
     * 用户id，对应mongo object id
     */
    private String userId;
    /**
     * 评论内容
     */
    private String content;
    /**
     * 创建时间
     */
    private Date createTime;


    public Integer getTargetId() {
        return targetId;
    }

    public void setTargetId(Integer targetId) {
        this.targetId = targetId;
    }

    public Object getTargetType() {
        return targetType;
    }

    public void setTargetType(Object targetType) {
        this.targetType = targetType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}