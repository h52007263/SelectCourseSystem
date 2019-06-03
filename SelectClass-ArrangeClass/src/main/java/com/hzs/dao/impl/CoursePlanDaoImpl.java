package com.hzs.dao.impl;

import com.hzs.dao.ICoursePlanDao;
import com.hzs.dao.base.BaseDaoImpl;
import com.hzs.model.Course;
import com.hzs.model.CoursePlan;
import com.hzs.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * @author hezhensheng
 * @version 1.0
 * @description 课程计划的dao实现类
 * @date 2019/5/30 14:02
 */

@Repository
public class CoursePlanDaoImpl extends BaseDaoImpl<CoursePlan> implements ICoursePlanDao {

    @Autowired
    private ICourseService courseService;

    public void save(CoursePlan entity,int courseId) {
        //课程计划表的最大id
        int courseplanId= (int) findMaxId();
        courseplanId+=1;
        //设置新对象的id，【权重，周节次通过前端注入了】
        entity.setCourseplanId(courseplanId);
        //设置新对象的course
        Course course=courseService.find(courseId);

        entity.setCourse(course);

        System.out.println(entity);

        super.save(entity);
    }

    @Override
    public void update(CoursePlan coursePlan, String courseName) {
        //通过courseName查询出课程对象
        Course course = courseService.findByField(courseName,"courseName");

        //注入 课程 对象到 课程计划 中
        coursePlan.setCourse(course);

        //注入课程计划关联的【课程】的属性
//        super.update(coursePlan);
        super.hibernateTemplate.merge(coursePlan);
    }

    @Override
    public Serializable findMaxId() {
        String hql="select MAX(courseplanId) from CoursePlan";
        List<Integer> ids = (List<Integer>) super.hibernateTemplate.find(hql);
        return ids.get(0);
    }
}
