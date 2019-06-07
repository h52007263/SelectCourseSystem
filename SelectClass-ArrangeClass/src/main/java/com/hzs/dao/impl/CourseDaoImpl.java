package com.hzs.dao.impl;

import com.hzs.dao.ICourseDao;
import com.hzs.dao.base.BaseDaoImpl;
import com.hzs.model.Course;
import com.hzs.model.Teacher;
import com.hzs.service.ITeacherService;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hezhensheng
 * @version 1.0
 * @description 课程的dao实现类
 * @date 2019/5/30 8:29
 */
@Repository
public class CourseDaoImpl extends BaseDaoImpl<Course> implements ICourseDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private ITeacherService teacherService;

    @Override
    public List<Course> findAllByMajor(String major, String grade) {
        String hql="from Course where major = ?0 and grade = ?1";
        Query query=sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter(0,major);
        query.setParameter(1,Integer.parseInt(grade));
        return query.list();
    }

    @Override
    public List<Course> findAllByThree(String major, String grade, String field, String condition) {
        String sql="select * from course where major like ?0 and grade like ?1 and "+field+" like ?2";
        Query query=sessionFactory.getCurrentSession().createSQLQuery(sql);
        query.setParameter(0,"%"+major+"%");
        query.setParameter(1,"%"+grade+"%");
        query.setParameter(2,"%"+condition+"%");

        List<Object[]> objects=query.list();
        List<Course> list=new ArrayList<>();

        for(Object[] objs:objects){
            int courseId=Integer.parseInt(objs[0].toString());
            int teacherId=Integer.parseInt(objs[1].toString());
            String courseName=objs[2].toString();
            String courseProperty=objs[3].toString();
            int credit=Integer.parseInt(objs[4].toString());
            int hour=Integer.parseInt(objs[5].toString());
            int capacity=Integer.parseInt(objs[6].toString());
            int grade1=Integer.parseInt(objs[7].toString());
            String major1=objs[8].toString();

           Teacher teacher = teacherService.find(teacherId);

//            int courseId, String courseName, String courseProperty, Integer courseHour,
//                    Integer courseCredit, Integer capacity, Integer grade, String major
            Course course=new Course(courseId,courseName,courseProperty,hour,credit,capacity,grade1,major1);
            course.setTeacher(teacher);
            list.add(course);
        }
        return list;
    }
}
