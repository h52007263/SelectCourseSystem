package com.hzs.service.impl;

import com.hzs.dao.ICourseDao;
import com.hzs.model.Course;
import com.hzs.model.PageBean;
import com.hzs.service.ICourseService;
import com.hzs.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * @author hezhensheng
 * @version 1.0
 * @description 课程的service实现类
 * @date 2019/5/30 8:31
 */
@Service
@Transactional
public class CourseServiceImpl extends BaseServiceImpl<Course> implements ICourseService {

    @Autowired
    private ICourseDao courseDao;

    @Override
    public void save(Course entity) {
        courseDao.save(entity);
    }

    @Override
    public void delete(Course entity) {
        courseDao.delete(entity);
    }

    @Override
    public void update(Course entity) {
        courseDao.update(entity);
    }

    @Override
    public Course find(Serializable id) {
        return courseDao.find(id);
    }

    @Override
    public List<Course> findAll() {
        return courseDao.findAll();
    }

    @Override
    public List<Course> pageQuery(PageBean<Course> pb) {
        return courseDao.pageQuery(pb);
    }

    @Override
    public List<Course> vagueQuery(String name) {
        return courseDao.vagueQuery(name);
    }

    @Override
    public List<Course> vagueQuery1(Object condition, String field) {
        return courseDao.vagueQuery1(condition,field);
    }

    @Override
    public Course findByField(Object condition, String field) {
        return courseDao.findByField(condition,field);
    }

    @Override
    public List<Course> findAllByMajor(String major, String grade) {
        return courseDao.findAllByMajor(major,grade);
    }

    @Override
    public List<Object> findByDistinct(Object field) {
        return courseDao.findByDistinct(field);
    }

    @Override
    public List<Course> findAllByThree(String major, String grade, String field, String condition) {
        if(field.equals("courseName"))
            field="course_name";
        else
            field="course_property";
        return courseDao.findAllByThree(major,grade,field,condition);
    }

    @Override
    public List<Course> findAllMajor() {
        return courseDao.findAllMajor();
    }

    @Override
    public List<Course> findByNameMajor(String major, String courseName) {
        return courseDao.findByNameMajor(major,courseName);
    }

    @Override
    public List<Course> findNoCourseByMajor(String major) {
        return courseDao.findNoCourseByMajor(major);
    }
}
