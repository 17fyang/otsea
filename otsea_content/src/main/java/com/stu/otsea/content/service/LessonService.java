package com.stu.otsea.content.service;

import com.stu.otsea.dao.LessonCollectDao;
import com.stu.otsea.dao.LessonDao;
import com.stu.otsea.entity.po.Lesson;
import com.stu.otsea.entity.po.LessonCollect;
import com.stu.otsea.web.rest.Rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: 乌鸦坐飞机亠
 * @date: 2021/1/2 17:12
 * @Description:
 */
@Service
public class LessonService {
    public static final Logger logger = LoggerFactory.getLogger(LessonService.class);

    @Autowired
    private LessonCollectDao lessonCollectDao;

    @Autowired
    private LessonDao lessonDao;


    /**
     * 查找我发布过的课程
     *
     * @param id
     * @return
     */
    public Rest<List<Lesson>> listMyLessons(String id) {
        Lesson lesson = new Lesson();
        lesson.setAuthorId(id);
        return new Rest<>(lessonDao.queryAll(lesson));
    }

    /**
     * 查询我收藏的课程
     *
     * @param id
     * @return
     */
    public Rest<List<Lesson>> listMyCollectLessons(String id) {
        LessonCollect lessonCollect = new LessonCollect();
        lessonCollect.setUserId(id);
        List<LessonCollect> collectList = lessonCollectDao.queryAll(lessonCollect);
        List<Lesson> list = new LinkedList<>();
        for (LessonCollect lc : collectList) {
            Lesson lesson = lessonDao.queryById(lc.getLessonId());
            if (lesson != null) list.add(lesson);
            else logger.error("there is a lesson id can not find value : {}", lc.getLessonId());
        }

        return new Rest<>(list);
    }
}
