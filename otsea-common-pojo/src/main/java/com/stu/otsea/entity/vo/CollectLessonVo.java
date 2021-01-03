package com.stu.otsea.entity.vo;

import com.stu.otsea.entity.Lesson;

import java.util.List;

/**
 * @author: 乌鸦坐飞机亠
 * @date: 2021/1/2 17:46
 * @Description:
 */
public class CollectLessonVo {
    private String id;
    private List<Lesson> collectLessons;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Lesson> getCollectLessons() {
        return collectLessons;
    }

    public void setCollectLessons(List<Lesson> collectLessons) {
        this.collectLessons = collectLessons;
    }
}
