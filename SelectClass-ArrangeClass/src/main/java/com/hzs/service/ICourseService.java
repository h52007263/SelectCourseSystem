package com.hzs.service;

import com.hzs.model.Course;
import com.hzs.service.base.IBaseService;

import java.util.List;

public interface ICourseService extends IBaseService<Course> {
    //按照专业和年级 查询
    public List<Course> findAllByMajor(String major, String grade);

    //按照专业，年级，课程性质的查询
    public List<Course> findAllByThree(String major,String grade,String field,String condition);
}
