package com.hzs.dao;

import com.hzs.dao.base.IBaseDao;
import com.hzs.model.Course;

import java.util.List;

public interface ICourseDao extends IBaseDao<Course> {
    //按照专业和年级 查询
    public List<Course> findAllByMajor(String major,String grade);

    //按照专业，年级，课程性质的查询
    public List<Course> findAllByThree(String major,String grade,String field,String condition);
}
