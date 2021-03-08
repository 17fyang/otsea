package com.stu.otsea.content.controller;

import com.stu.otsea.content.service.PostService;
import com.stu.otsea.entity.vo.PostInfoVo;
import com.stu.otsea.web.rest.Rest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: 乌鸦坐飞机亠
 * @date: 2021/1/3 15:51
 * @Description:
 */
@RestController
@RequestMapping(value = "/otsea/content/post", method = {RequestMethod.POST, RequestMethod.GET})
public class PostController {

    @Autowired
    private PostService postService;

    @RequestMapping("/listAction")
    public Rest<List<PostInfoVo>> listAction() {
        return new Rest<>(postService.listPost());
    }

    @RequestMapping("/detail")
    public PostInfoVo detailAction(int postId) {
        return postService.getPostInfoVoById(postId);
    }
}
