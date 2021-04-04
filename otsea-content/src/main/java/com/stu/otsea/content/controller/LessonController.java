package com.stu.otsea.content.controller;

import com.stu.otsea.content.service.LessonService;
import com.stu.otsea.content.service.ResourceService;
import com.stu.otsea.entity.po.Resource;
import com.stu.otsea.entity.vo.LessonInfoVo;
import com.stu.otsea.web.aop.IdThreadLocal;
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

    @Autowired
    private ResourceService resourceService;

    @Token
    @RequestMapping("/myLessons")
    public Rest<List<LessonInfoVo>> listMyLessons() {
        String id = IdThreadLocal.INSTANCE.get();
        return new Rest<>(lessonService.listMyLessons(id));
    }

    @Token
    @RequestMapping("/myRecords")
    public Rest<List<LessonInfoVo>> listMyRecord() {
        String id = IdThreadLocal.INSTANCE.get();
        return new Rest<>(lessonService.listMyCollectLessons(id));
    }

    @Token
    @RequestMapping("/myCollectLessons")
    public Rest<List<LessonInfoVo>> listMyCollectLessons() {
        String id = IdThreadLocal.INSTANCE.get();
        return new Rest<>(lessonService.listMyCollectLessons(id));
    }

    @Token
    @RequestMapping("/setCollect")
    public Rest<Boolean> setCollect(Integer lessonId) {
        String id = IdThreadLocal.INSTANCE.get();
        return new Rest<>(lessonService.setCollect(id, lessonId));
    }

    @RequestMapping("/insertLesson")
    public Rest<String> insertLesson(String userId, String lessonName, String lessonIntro,
                                     String lessonImage, String lessonDir) {
        return new Rest<>(lessonService.insertLesson(userId, lessonName, lessonIntro, lessonImage, lessonDir));
    }

    @RequestMapping("/listAction")
    public Rest<List<LessonInfoVo>> listAction() {
        return new Rest<>(lessonService.listAction());
    }

    @RequestMapping("lastWatchLesson")
    public Rest<LessonInfoVo> lastWatchLesson(String id) {
        return new Rest<>(lessonService.getLastWatchLesson(id));
    }

    @RequestMapping("/resource")
    public Rest<Resource> resourceDetail(Integer id) {
        return new Rest<>(resourceService.getResourceById(id));
    }

    @RequestMapping("/search")
    public Rest<List<LessonInfoVo>> search(String key) {
        return new Rest<>(lessonService.search(key));
    }

    @RequestMapping("setLook")
    public Rest<String> setLook(int lessonId) {
        return lessonService.setLook(lessonId) ? Rest.ok() : Rest.fail();
    }

}
