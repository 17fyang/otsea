package com.stu.otsea.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.Date;

/**
 * (Post)实体类
 *
 * @author 乌鸦坐飞机亠
 * @since 2021-01-03 15:26:37
 */
public class Post implements Serializable {
    private static final long serialVersionUID = -22887944946452180L;
    /**
     * 帖子id，自增主键
     */
    @TableId(type = IdType.AUTO)
    private Integer postId;
    /**
     * 作者id，对应mongo object id
     */
    private String authorId;
    /**
     * 帖子标题
     */
    private String title;
    /**
     * 帖子内容
     */
    private String content;
    /**
     * 帖子类型，0：文字帖，1：视频帖
     */
    private Short postType;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Short getPostType() {
        return postType;
    }

    public void setPostType(Short postType) {
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