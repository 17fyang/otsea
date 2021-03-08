package com.stu.otsea.entity.vo;

import com.stu.otsea.entity.po.Lesson;
import com.stu.otsea.entity.po.Resource;

/**
 * @author: 乌鸦坐飞机亠
 * @date: 2021/1/3 15:07
 * @Description: 前端展示的一个课程的vo
 */
public class LessonInfoVo {
    private Lesson lesson;
    private Resource resource;
    private UserInfoVo authorInfo;


    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public UserInfoVo getAuthorInfo() {
        return authorInfo;
    }

    public void setAuthorInfo(UserInfoVo authorInfo) {
        this.authorInfo = authorInfo;
    }
}
