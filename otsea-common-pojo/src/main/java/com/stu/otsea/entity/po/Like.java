package com.stu.otsea.entity.po;

import java.io.Serializable;
import java.util.Date;

/**
 * (Like)实体类
 *
 * @author 乌鸦坐飞机亠
 * @since 2021-01-03 15:26:37
 */
public class Like implements Serializable {
    private static final long serialVersionUID = 793326517043109273L;
    /**
     * 资源id
     */
    private Integer targetId;
    /**
     * 资源类型，0：帖子，1：课程
     */
    private Short targetType;
    /**
     * 用户id，对应mongo object id
     */
    private String userId;
    /**
     * 发布时间
     */
    private Date createTime;


    public Integer getTargetId() {
        return targetId;
    }

    public void setTargetId(Integer targetId) {
        this.targetId = targetId;
    }

    public Short getTargetType() {
        return targetType;
    }

    public void setTargetType(Short targetType) {
        this.targetType = targetType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}