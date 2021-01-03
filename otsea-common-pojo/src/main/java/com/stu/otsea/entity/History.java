package com.stu.otsea.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (History)实体类
 *
 * @author 乌鸦坐飞机亠
 * @since 2021-01-03 15:26:36
 */
public class History implements Serializable {
    private static final long serialVersionUID = -41317395771891516L;
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
     * 创建时间
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