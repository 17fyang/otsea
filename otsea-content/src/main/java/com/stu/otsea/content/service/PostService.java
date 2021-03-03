package com.stu.otsea.content.service;

import com.stu.otsea.api.service.IUserService;
import com.stu.otsea.dao.PostDao;
import com.stu.otsea.dao.ResourceDao;
import com.stu.otsea.entity.po.Post;
import com.stu.otsea.entity.vo.PostInfoVo;
import com.stu.otsea.entity.vo.UserInfoVo;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Reference
    private IUserService userService;

    /**
     * 根据id获取一个帖子的展示信息
     *
     * @return
     */
    public PostInfoVo getPostInfoVoById(int postId) {
        Post post = postDao.selectById(postId);
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
        UserInfoVo authorInfo = userService.getUserInfoVoById(post.getAuthorId());
        postInfoVo.setAuthorInfo(authorInfo);
        return postInfoVo;
    }

    /**
     * 获取帖子列表
     *
     * @return
     */
    public List<PostInfoVo> listPost() {
        List<Post> postList = postDao.selectList(null);

        List<PostInfoVo> postInfoVoList = new ArrayList<>(postList.size());
        for (Post post : postList) {
            postInfoVoList.add(this.getPostInfoVoByPost(post));
        }

        return postInfoVoList;
    }


}
