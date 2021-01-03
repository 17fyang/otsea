package com.stu.otsea.content.service;

import com.stu.otsea.dao.PostDao;
import com.stu.otsea.dao.ResourceDao;
import com.stu.otsea.entity.Post;
import com.stu.otsea.entity.Resource;
import com.stu.otsea.entity.vo.PostInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: 乌鸦坐飞机亠
 * @date: 2021/1/3 15:52
 * @Description:
 */
@Service
public class PostService {
    @Autowired
    private PostDao postDao;

    @Autowired
    private ResourceDao resourceDao;

    /**
     * 根据id获取一个帖子的展示信息
     *
     * @return
     */
    public PostInfoVo getPostInfoVoById(int postId) {
        Post post = postDao.queryById(postId);
        return this.getPostInfoVoByPost(post);
    }

    /**
     * 根据Post对象获取一个帖子的展示信息
     *
     * @param post
     * @return
     */
    public PostInfoVo getPostInfoVoByPost(Post post) {
        PostInfoVo postInfoVo = new PostInfoVo();
        postInfoVo.setPost(post);
        Resource resource = resourceDao.queryById(post.getResourceId());
        postInfoVo.setResource(resource);
        return postInfoVo;
    }
}
