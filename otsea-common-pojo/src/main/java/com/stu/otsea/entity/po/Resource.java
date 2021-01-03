package com.stu.otsea.entity.po;

import java.io.Serializable;
import java.util.Date;

/**
 * (Resource)实体类
 *
 * @author 乌鸦坐飞机亠
 * @since 2021-01-02 17:18:37
 */
public class Resource implements Serializable {
    private static final long serialVersionUID = -34728340189878164L;
    /**
     * 资源id，自增主键
     */
    private Integer resourceId;
    /**
     * 资源路径
     */
    private String resourcePath;
    /**
     * 资源类型
     */
    private Object resourceType;
    /**
     * 扩展字段，json格式
     */
    private String infomation;
    /**
     * 创建时间
     */
    private Date createTime;


    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public String getResourcePath() {
        return resourcePath;
    }

    public void setResourcePath(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    public Object getResourceType() {
        return resourceType;
    }

    public void setResourceType(Object resourceType) {
        this.resourceType = resourceType;
    }

    public String getInfomation() {
        return infomation;
    }

    public void setInfomation(String infomation) {
        this.infomation = infomation;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}