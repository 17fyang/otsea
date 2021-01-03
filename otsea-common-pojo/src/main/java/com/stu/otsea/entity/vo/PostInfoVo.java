package com.stu.otsea.entity.vo;

import com.stu.otsea.entity.Post;
import com.stu.otsea.entity.Resource;

/**
 * @author: 乌鸦坐飞机亠
 * @date: 2021/1/3 15:54
 * @Description:
 */
public class PostInfoVo {
    private Post post;
    private Resource resource;
    private Object authorInfo;

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public Object getAuthorInfo() {
        return authorInfo;
    }

    public void setAuthorInfo(Object authorInfo) {
        this.authorInfo = authorInfo;
    }
}
