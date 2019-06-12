package com.hzs.service.impl;

import com.hzs.dao.ICourseDao;
import com.hzs.dao.ICoursePlanDao;
import com.hzs.dao.ICourseWishDao;
import com.hzs.model.Course;
import com.hzs.model.CoursePlan;
import com.hzs.model.CourseWish;
import com.hzs.model.PageBean;
import com.hzs.service.ICoursePlanService;
import com.hzs.service.ICourseWishService;
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

    @Autowired
    private ICourseWishDao courseWishDao;

    @Autowired
    private ICourseWishService courseWishService;

    @Autowired
    private ICourseDao courseDao;

    @Override
    public void save(CoursePlan entity) {
        coursePlanDao.save(entity);
    }

    @Override
    public void delete(CoursePlan entity) {
//        int courseId=entity.getCourse().getCourseId();
        coursePlanDao.delete(entity);
//        CourseWish courseWish=courseWishDao.find(courseId);
//        courseWish.setCourseId(0);
//        courseWish.setWeight(0);
//        courseWish.setSection(0);
//        courseWish.setWeight(0);
//        courseWishDao.update(courseWish);
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
    public void save(CoursePlan entity, String major,String courseName) {

        List<Course> courses = courseDao.findByNameMajor(major,courseName);
        Course course=courses.get(0);
        entity.setCourse(course);
        //添加课程计划
        coursePlanDao.save(entity,courseName);


        //添加课程意向
        CourseWish courseWish=new CourseWish();
        courseWish.setCourse(course);
        courseWish.setCourseId(course.getCourseId());
        courseWish.setCourseName(course.getCourseName());
        //注入0
        courseWish.setWeight(entity.getWeight());
        courseWish.setAmpm(12);
        courseWish.setJoins(0);
        courseWish.setSection(entity.getSection());
        courseWishDao.save(courseWish);
    }

    @Override
    public void update(CoursePlan model, String courseName) {
        CourseWish courseWish = courseWishDao.findByField(courseName,"courseName");
        courseWish.setWeight(model.getWeight());
        courseWish.setSection(model.getSection());
        courseWishService.update(courseWish);
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

    @Override
    public void updateCascade(CoursePlan coursePlan) {
        coursePlanDao.updateCascade(coursePlan);
    }
}
