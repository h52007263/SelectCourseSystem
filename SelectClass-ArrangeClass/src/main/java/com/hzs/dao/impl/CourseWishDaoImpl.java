package com.hzs.dao.impl;

import com.hzs.dao.ICourseDao;
import com.hzs.dao.ICourseWishDao;
import com.hzs.dao.base.BaseDaoImpl;
import com.hzs.model.Course;
import com.hzs.model.CourseWish;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hezhensheng
 * @version 1.0
 * @description CourseWishDaoImpl
 * @date 2019/6/5 18:16
 */

@Repository
public class CourseWishDaoImpl extends BaseDaoImpl<CourseWish> implements ICourseWishDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private ICourseDao courseDao;

    @Override
    public Integer findByMaxId() {
        String hql="select MAX(courseId) from CourseWish";
        List<Integer> ids = (List<Integer>) hibernateTemplate.find(hql);
        return ids.get(0);
    }

    @Override
    public List<CourseWish> vagueQueryByMajor(String major, String grade) {
        String sql="select cw.course_id,cw.ampm,cw.course_name,cw.joins,cw.section,cw.weight" +
                " from course_wish cw,course c where cw.course_id = c.course_id" +
                " and c.major = ?0 and c.grade = ?1";

        Session session=sessionFactory.openSession();
        Query query=session.createSQLQuery(sql);
        query.setParameter(0,major);
        query.setParameter(1,grade);

        System.out.println(query.list().size());

        List<Object[]> list=query.list();
        List<CourseWish> courseWishes=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            Object[] objs=list.get(i);
            int courseId=Integer.parseInt(objs[0].toString());
            int ampm=Integer.parseInt(objs[1].toString());
            String courseName=objs[2].toString();
            int joins=Integer.parseInt(objs[3].toString());
            int section=Integer.parseInt(objs[4].toString());
            int weight=Integer.parseInt(objs[5].toString());

            CourseWish courseWish=new CourseWish(courseId,courseName,weight,section,joins,ampm);
            Course course=courseDao.find(courseId);
            courseWish.setCourse(course);
            courseWishes.add(courseWish);
        }
        return courseWishes;
    }

    @Override
    public void updatePure(CourseWish courseWish) {
        hibernateTemplate.update(courseWish);
    }
}
