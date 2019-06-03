package com.hzs.service;

import com.hzs.model.CoursePlan;
import com.hzs.service.base.IBaseService;

import java.io.Serializable;

public interface ICoursePlanService extends IBaseService<CoursePlan> {
    //返回当前表中最大的id
    public Serializable findMaxId();

    //增加【关联课程的增加】
    public void save(CoursePlan entity,int courseId);

    public void update(CoursePlan model, String courseName);
}
