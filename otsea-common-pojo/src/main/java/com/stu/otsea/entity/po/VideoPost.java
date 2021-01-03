package com.stu.otsea.entity.po;

import java.io.Serializable;
import java.util.Date;

/**
 * (VideoPost)实体类
 *
 * @author 乌鸦坐飞机亠
 * @since 2021-01-02 18:13:28
 */
public class VideoPost implements Serializable {
    private static final long serialVersionUID = -99351663550136671L;
    /**
     * 主键id
     */
    private Integer videoId;
    /**
     * 作者id
     */
    private String userId;
    /**
     * 标题
     */
    private String title;
    /**
     * 资源id
     */
    private Integer resourceId;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 内容状态
     */
    private Object status;


    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }

}