package com.stu.otsea.api.service;

import com.stu.otsea.entity.vo.LessonInfoVo;

public interface ILessonService {
    /**
     * 根据id获取一个课程的展示信息
     *
     * @return
     */
    LessonInfoVo getLessonInfoVoById(int lessonId);
}
