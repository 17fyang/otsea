package com.stu.otsea.content.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.stu.otsea.dao.LessonCollectDao;
import com.stu.otsea.dao.LessonDao;
import com.stu.otsea.dao.ResourceDao;
import com.stu.otsea.entity.po.Lesson;
import com.stu.otsea.entity.po.LessonCollect;
import com.stu.otsea.entity.po.Resource;
import com.stu.otsea.entity.vo.LessonInfoVo;
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

    @Autowired
    private ResourceDao resourceDao;


    /**
     * 查找我发布过的课程
     *
     * @param id
     * @return
     */
    public Rest<List<LessonInfoVo>> listMyLessons(String id) {
        QueryWrapper<Lesson> lessonQueryWrapper = new QueryWrapper<>();
        lessonQueryWrapper.eq("authorId", id);

        List<Lesson> lessons = lessonDao.selectList(lessonQueryWrapper);

        List<LessonInfoVo> lessonInfoVoList = new LinkedList<>();
        for (Lesson lesson : lessons) {
            LessonInfoVo lessonInfoVo = this.getLessonInVoByLesson(lesson);
            lessonInfoVoList.add(lessonInfoVo);
        }

        return new Rest<>(lessonInfoVoList);
    }

    /**
     * 查询我收藏的课程
     *
     * @param id
     * @return
     */
    public Rest<List<LessonInfoVo>> listMyCollectLessons(String id) {
        QueryWrapper<LessonCollect> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userId", id);
        List<LessonCollect> collectList = lessonCollectDao.selectList(queryWrapper);

        List<LessonInfoVo> list = new LinkedList<>();
        for (LessonCollect lc : collectList) {
            LessonInfoVo lessonInfoVo = this.getLessonInfoVoById(lc.getLessonId());
            list.add(lessonInfoVo);
        }
        return new Rest<>(list);
    }

    /**
     * 根据id获取一个课程的展示信息
     *
     * @return
     */
    public LessonInfoVo getLessonInfoVoById(int lessonId) {
        Lesson lesson = lessonDao.selectById(lessonId);
        return this.getLessonInVoByLesson(lesson);
    }

    /**
     * 根据Lesson对象获取一个课程的展示信息
     *
     * @param lesson
     * @return
     */
    public LessonInfoVo getLessonInVoByLesson(Lesson lesson) {
        LessonInfoVo lessonInfoVo = new LessonInfoVo();
        lessonInfoVo.setLesson(lesson);
        Resource titleImage = resourceDao.selectById(lesson.getTitleImageId());
        lessonInfoVo.setResource(titleImage);
        return lessonInfoVo;
    }
}
