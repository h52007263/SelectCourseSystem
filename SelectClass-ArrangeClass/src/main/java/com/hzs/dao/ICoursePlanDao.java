package com.hzs.dao;

import com.hzs.dao.base.IBaseDao;
import com.hzs.model.Course;
import com.hzs.model.CoursePlan;

import java.io.Serializable;
import java.util.List;

public interface ICoursePlanDao extends IBaseDao<CoursePlan> {

    //查询最后一条id最大的记录
    public Serializable findMaxId();

    //增加，关联课程的增加
    public void save(CoursePlan entity,int courseId);

    //更新，关联课程的更新
    public void update(CoursePlan coursePlan,String courseName);

    //按照专业和年级模糊查询
    public List<CoursePlan> vagueQueryByMajor(String major,String grade);

    //查询课程表中没有加入课程计划的课程
    public List<Course> findCourse();

}
