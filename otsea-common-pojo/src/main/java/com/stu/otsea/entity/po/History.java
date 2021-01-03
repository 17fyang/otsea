package com.stu.otsea.entity.po;

import java.io.Serializable;
import java.util.Date;

/**
 * (History)实体类
 *
 * @author 乌鸦坐飞机亠
 * @since 2021-01-02 17:18:36
 */
public class History implements Serializable {
    private static final long serialVersionUID = -71067083126381294L;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}