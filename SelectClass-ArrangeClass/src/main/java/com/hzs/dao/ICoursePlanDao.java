package com.hzs.dao;

import com.hzs.dao.base.IBaseDao;
import com.hzs.model.Course;
import com.hzs.model.CoursePlan;

import java.io.Serializable;

public interface ICoursePlanDao extends IBaseDao<CoursePlan> {

    //查询最后一条记录的id
    public Serializable findMaxId();

    //增加，关联课程的增加
    public void save(CoursePlan entity,int courseId);

    //更新，关联课程的更新
    public void update(CoursePlan coursePlan,String courseName);

}
