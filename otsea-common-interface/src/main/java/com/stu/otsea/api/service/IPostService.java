package com.stu.otsea.api.service;

import com.stu.otsea.entity.vo.PostInfoVo;

public interface IPostService {
    /**
     * 根据id获取一个帖子的展示信息
     *
     * @return
     */
    PostInfoVo getPostInfoVoById(int postId);

}
