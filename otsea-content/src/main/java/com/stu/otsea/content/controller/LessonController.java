package com.stu.otsea.content.controller;

import com.stu.otsea.content.service.LessonService;
import com.stu.otsea.entity.vo.LessonInfoVo;
import com.stu.otsea.web.aop.Token;
import com.stu.otsea.web.rest.Rest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: 乌鸦坐飞机亠
 * @date: 2021/1/2 17:12
 * @Description:
 */
@RestController
@RequestMapping(value = "/otsea/content/lesson", method = {RequestMethod.POST, RequestMethod.GET})
public class LessonController {
    @Autowired
    private LessonService lessonService;

    @Token
    @RequestMapping("/myLessons")
    public Rest<List<LessonInfoVo>> listMyLessons(String id) {
        // todo 这里应该是限制本人访问的接口，考虑在token中加入该功能
        return lessonService.listMyLessons(id);
    }

    @Token
    @RequestMapping("myCollectLessons")
    public Rest<List<LessonInfoVo>> listMyCollectLessons(String id) {
        return lessonService.listMyCollectLessons(id);
    }
}
