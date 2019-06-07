package com.hzs.dao.impl;

import com.hzs.dao.IArrangeResultDao;
import com.hzs.dao.base.BaseDaoImpl;
import com.hzs.model.ArrangeResult;
import com.hzs.model.Classroom;
import com.hzs.model.Course;
import com.hzs.model.CourseWish;
import com.hzs.service.IClassroomService;
import com.hzs.service.ICourseService;
import com.hzs.service.ICourseWishService;
import com.hzs.util.AutoArrangeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hezhensheng
 * @version 1.0
 * @description ArrangeResultDaoImpl
 * @date 2019/6/6 23:08
 */

@Repository
public class ArrangeResultDaoImpl extends BaseDaoImpl<ArrangeResult> implements IArrangeResultDao {

    @Autowired
    private ICourseWishService courseWishService;

    @Autowired
    private IClassroomService classroomService;

    @Autowired
    private ICourseService courseService;

    @Override
    public List<ArrangeResult> generateResult(Map<Integer, String> map, String major, String grade) {
        List<CourseWish> courses=courseWishService.findAll();
        String[] result=new String[21];
        Arrays.fill(result,"0");

        //获取选课结果  课程时间 课程名称
        result= AutoArrangeUtil.arrange(courses,map);

        //输出结果
        AutoArrangeUtil.pringTimeTable(result);

        //String[] wishs, List<Classroom> classrooms, Map<String,Integer> map, String major, int grade

        //查询教室
        List<Classroom> classrooms=classroomService.findAllAscByCap();
        //查询排的课程
        List<Course> courses1=courseService.findAllByMajor(major,grade);
        //得到课程的容量
        Map<String,Integer> map1=new HashMap<>();
        //得到课程的教师
        Map<String,String> mapTeacher=new HashMap<>();
        for(Course course:courses1)
            map1.put(course.getCourseName(),course.getCapacity());
        for(Course course:courses1){
            mapTeacher.put(course.getCourseName(),course.getTeacher().getName());
        }
        //获取最后的结果
        List<ArrangeResult> resultList = AutoArrangeUtil.fillRoom(result,classrooms,map1,mapTeacher,major,Integer.parseInt(grade));

        return resultList;
    }
}
