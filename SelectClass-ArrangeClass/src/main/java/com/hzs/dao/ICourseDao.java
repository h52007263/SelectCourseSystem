package com.hzs.dao;

import com.hzs.dao.base.IBaseDao;
import com.hzs.model.Course;

import java.util.List;

public interface ICourseDao extends IBaseDao<Course> {
    //按照专业和年级 查询
    public List<Course> findAllByMajor(String major,String grade);

    //按照专业，年级，课程性质的查询
    public List<Course> findAllByThree(String major,String grade,String field,String condition);

    //获取所有专业
    public List<Course> findAllMajor();

    //通过课程名和专业查询课程对象
    public List<Course> findByNameMajor(String major,String courseName);

    //获取某专业没有被添加到课程计划的课程
    public List<Course> findNoCourseByMajor(String major);
}
