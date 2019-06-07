package com.hzs.service.impl;

import com.hzs.dao.ICoursePlanDao;
import com.hzs.model.Course;
import com.hzs.model.CoursePlan;
import com.hzs.model.PageBean;
import com.hzs.service.ICoursePlanService;
import com.hzs.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * @author hezhensheng
 * @version 1.0
 * @description 课程计划的service的实现类
 * @date 2019/5/30 14:05
 */

@Service
@Transactional
public class CoursePlanServiceImpl extends BaseServiceImpl<CoursePlan> implements ICoursePlanService {

    @Autowired
    private ICoursePlanDao coursePlanDao;

    @Override
    public void save(CoursePlan entity) {
        coursePlanDao.save(entity);
    }

    @Override
    public void delete(CoursePlan entity) {
        coursePlanDao.delete(entity);
    }

    @Override
    public void update(CoursePlan entity) {
        coursePlanDao.update(entity);
    }

    @Override
    public CoursePlan find(Serializable id) {
        return coursePlanDao.find(id);
    }

    @Override
    public List<CoursePlan> findAll() {
        return coursePlanDao.findAll();
    }

    @Override
    public List<CoursePlan> pageQuery(PageBean<CoursePlan> pb) {
        return coursePlanDao.pageQuery(pb);
    }

    @Override
    public List<CoursePlan> vagueQuery(String name) {
        return coursePlanDao.vagueQuery(name);
    }

    @Override
    public List<CoursePlan> vagueQuery1(Object condition, String field) {
        return coursePlanDao.vagueQuery1(condition,field);
    }

    @Override
    public CoursePlan findByField(Object condition, String field) {
        return coursePlanDao.findByField(condition,field);
    }

    @Override
    public Serializable findMaxId() {
        return coursePlanDao.findMaxId();
    }

    @Override
    public void save(CoursePlan entity, int courseId) {
        coursePlanDao.save(entity,courseId);
    }

    @Override
    public void update(CoursePlan model, String courseName) {
        coursePlanDao.update(model,courseName);
    }

    @Override
    public List<CoursePlan> vagueQueryByMajor(String major, String grade) {
        return coursePlanDao.vagueQueryByMajor(major,grade);
    }

    @Override
    public List<Course> findCourse() {
        return coursePlanDao.findCourse();
    }
}
