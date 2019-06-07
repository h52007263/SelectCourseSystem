package com.hzs.service;

import com.hzs.model.Course;
import com.hzs.model.CoursePlan;
import com.hzs.service.base.IBaseService;

import java.io.Serializable;
import java.util.List;

public interface ICoursePlanService extends IBaseService<CoursePlan> {
    //返回当前表中最大的id
    public Serializable findMaxId();

    //增加【关联课程的增加】
    public void save(CoursePlan entity,int courseId);

    public void update(CoursePlan model, String courseName);

    //模糊查询专业和年级
    public List<CoursePlan> vagueQueryByMajor(String major,String grade);

    //查询课程表中没有加入课程计划的课程
    public List<Course> findCourse();
}
