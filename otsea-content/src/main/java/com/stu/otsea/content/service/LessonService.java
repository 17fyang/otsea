package com.stu.otsea.content.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.stu.otsea.api.service.IUserService;
import com.stu.otsea.dao.LessonCollectDao;
import com.stu.otsea.dao.LessonDao;
import com.stu.otsea.entity.po.Lesson;
import com.stu.otsea.entity.po.LessonCollect;
import com.stu.otsea.entity.po.Resource;
import com.stu.otsea.entity.vo.LessonInfoVo;
import com.stu.otsea.entity.vo.UserInfoVo;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    private ResourceService resourceService;

    @Reference
    private IUserService userService;


    /**
     * 查找我发布过的课程
     *
     * @return
     */
    public List<LessonInfoVo> listMyLessons(String id) {


        QueryWrapper<Lesson> lessonQueryWrapper = new QueryWrapper<>();
        lessonQueryWrapper.eq("author_id", id);

        List<Lesson> lessons = lessonDao.selectList(lessonQueryWrapper);

        List<LessonInfoVo> lessonInfoVoList = new LinkedList<>();
        for (Lesson lesson : lessons) {
            LessonInfoVo lessonInfoVo = this.getLessonInVoByLesson(lesson);
            lessonInfoVoList.add(lessonInfoVo);
        }

        return lessonInfoVoList;
    }

    /**
     * 查询我收藏的课程
     *
     * @param id
     * @return
     */
    public List<LessonInfoVo> listMyCollectLessons(String id) {
        QueryWrapper<LessonCollect> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", id);
        List<LessonCollect> collectList = lessonCollectDao.selectList(queryWrapper);

        List<LessonInfoVo> list = new LinkedList<>();
        for (LessonCollect lc : collectList) {
            LessonInfoVo lessonInfoVo = this.getLessonInfoVoById(lc.getLessonId());
            list.add(lessonInfoVo);
        }
        return list;
    }

    public boolean setCollect(String userId, int lessonId) {
        return true;
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

        Resource titleImage = resourceService.getResourceById(lesson.getTitleImageId());
        lessonInfoVo.setTitleImage(titleImage);
        lesson.setTitleImageId(null);

        UserInfoVo authorInfoVo = userService.getUserInfoVoById(lesson.getAuthorId());
        lessonInfoVo.setAuthorInfo(authorInfoVo);
        lesson.setAuthorId(null);

        return lessonInfoVo;
    }

    /**
     * 获取推荐的课程列表
     *
     * @return
     */
    public List<LessonInfoVo> listAction() {
        QueryWrapper<Lesson> queryWrapper = new QueryWrapper<>();
        queryWrapper.between("lesson_id", 0, 10);
        List<Lesson> lessonList = lessonDao.selectList(queryWrapper);
        List<LessonInfoVo> lessonInfoVoList = new LinkedList<>();
        for (Lesson lesson : lessonList) {
            lessonInfoVoList.add(this.getLessonInVoByLesson(lesson));
        }
        return lessonInfoVoList;
    }

    /**
     * 获取上次看到的lesson
     *
     * @param id
     * @return
     */
    public LessonInfoVo getLastWatchLesson(String id) {
        return getLessonInfoVoById(5);
    }

    /**
     * 搜索查询
     *
     * @param key
     * @return
     */
    public List<LessonInfoVo> search(String key) {
        QueryWrapper<Lesson> wrapper = new QueryWrapper<>();
        wrapper.like(true, "folder_structure", key);
        wrapper.or().like(true, "introduce", key);
        wrapper.or().like(true, "title", key);

        List<Lesson> lessonList = lessonDao.selectList(wrapper);

        List<LessonInfoVo> lessonInfoVoList = new ArrayList<>(lessonList.size());
        for (Lesson lesson : lessonList) {
            lessonInfoVoList.add(this.getLessonInVoByLesson(lesson));
        }
        return lessonInfoVoList;
    }

    /**
     * 设置观看了某个课程
     *
     * @param lessonId
     */
    public boolean setLook(int lessonId) {
        return true;
    }

    /**
     * 插入一个课程数据，用于爬虫
     *
     * @param userId
     * @param lessonName
     * @param lessonIntro
     * @param lessonImage
     * @param lessonDir
     * @return
     */
    public String insertLesson(String userId, String lessonName, String lessonIntro, String lessonImage, String lessonDir) {
        int resourceId = resourceService.insertImage(lessonImage);

        Lesson lesson = new Lesson();
        lesson.setAuthorId(userId);
        lesson.setTitleImageId(resourceId);
        lesson.setTitle(lessonName);
        lesson.setIntroduce(lessonIntro);
        lesson.setFolderStructure(lessonDir);

        lessonDao.insert(lesson);
        return null;
    }
}
