package com.stu.otsea.dao.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (Post)实体类
 *
 * @author 乌鸦坐飞机亠
 * @since 2021-01-03 14:05:11
 */
public class Post implements Serializable {
    private static final long serialVersionUID = -74334290715844863L;
    /**
     * 帖子id，自增主键
     */
    private Integer postId;
    /**
     * 作者id，对应mongo object id
     */
    private String authorId;
    /**
     * 帖子内容
     */
    private String content;
    /**
     * 帖子类型，0：文字帖，1：视频帖
     */
    private Object postType;
    /**
     * 资源路径，如果没有资源则为-1
     */
    private Integer resourceId;
    /**
     * 发布时间
     */
    private Date createTime;


    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Object getPostType() {
        return postType;
    }

    public void setPostType(Object postType) {
        this.postType = postType;
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

}