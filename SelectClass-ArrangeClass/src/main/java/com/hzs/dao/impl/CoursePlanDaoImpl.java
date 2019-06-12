package com.hzs.dao.impl;

import com.hzs.dao.ICourseDao;
import com.hzs.dao.ICoursePlanDao;
import com.hzs.dao.base.BaseDaoImpl;
import com.hzs.model.Course;
import com.hzs.model.CoursePlan;
import com.hzs.service.ICoursePlanService;
import com.hzs.service.ICourseService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
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
    private SessionFactory sessionFactory;

    @Autowired
    private ICourseService courseService;

    @Autowired
    private ICourseDao courseDao;

    @Autowired
    private ICoursePlanService coursePlanService;

    public void save(CoursePlan entity,String courseName) {
        //课程计划表的最大id
        int courseplanId= (int) findMaxId()+1;
        //设置新对象的id，【权重，周节次通过前端注入了】
        entity.setCourseplanId(courseplanId);
        //设置新对象的course
//        Course course=courseService.findByField(courseName,"courseName");

//        entity.setCourse(course);

//        System.out.println(entity);

        super.hibernateTemplate.merge(entity);
    }

    @Override
    public void update(CoursePlan coursePlan, String courseName) {
//        通过courseName查询出课程对象
        Course course = courseService.findByField(courseName,"courseName");

//        注入 课程 对象到 课程计划 中
        coursePlan.setCourse(course);

        hibernateTemplate.setCheckWriteOperations(false);

        //注入课程计划关联的【课程】的属性
//        super.hibernateTemplate.update(coursePlan);
          hibernateTemplate.merge("coursePlan",coursePlan);


//        String sql="update course_plan set weight=?0,section=?1,course_id=?2 where courseplan_id=?3";
//        Query query = sessionFactory.openSession().createSQLQuery(sql);
//        query.setParameter(0,coursePlan.getWeight());
//        query.setParameter(1,coursePlan.getSection());
//        query.setParameter(2,coursePlan.getCourseplanId());
//        query.setParameter(3,coursePlan.getCourseplanId());
//
//        query.executeUpdate();

    }

    //通过专业和年级查询课程计划，以课程计划为主，比如查询出课程1，2，3  但是排计划的只有1，2  那么结果是1，2
    @Override
    public List<CoursePlan> vagueQueryByMajor(String major, String grade) {

        String sql="select * from course_plan where courseplan_id in " +
                "(select course_id from course where major like ?0 and grade like ?1)";
        Session session=sessionFactory.getCurrentSession();
        Query query=session.createSQLQuery(sql);
        query.setParameter(0,"%"+major+"%");
        query.setParameter(1,"%"+grade+"%");

        System.out.println(query.list().size());

        List<Object[]> list=query.list();

        List<CoursePlan> coursePlans=new ArrayList<>();

        for(int i=0;i<list.size();i++){
            Object[] objs= (Object[]) list.get(i);
            int coursePlanId = (int) objs[0];
            int weight = (int) objs[1];
            int section = (int) objs[2];
            int courseId= (int) objs[3];
            Course course=courseService.find(courseId);
            CoursePlan coursePlan=new CoursePlan(coursePlanId,weight,section);
            coursePlan.setCourse(course);
            coursePlans.add(coursePlan);
        }

        return coursePlans;
    }

    @Override
    public List<Course> findCourse() {
        List<Course> courses = courseService.findAll();
        List<CoursePlan> coursePlans = coursePlanService.findAll();
        for (int i = 0; i < courses.size(); i++) {
            for (int j = 0; j < coursePlans.size(); j++) {
                if(courses.get(i).getCourseName().equals(coursePlans.get(j).getCourse().getCourseName())){
                    courses.remove(i);
                }
            }
        }
        return courses;
    }

    @Override
    public void updateCascade(CoursePlan coursePlan) {
        int weight=coursePlan.getWeight();
        int section=coursePlan.getSection();
        int courseplanId=coursePlan.getCourseplanId();
        String sql="update course_plan cp,course_wish cw set cp.weight=?0,cp.section=?1,cw.weight=?2,cw.section=?3 where courseplan_id=?4" +
                " and cw.course_id=cp.course_id";
        Query query=sessionFactory.getCurrentSession().createSQLQuery(sql);
        query.setParameter(0,weight);
        query.setParameter(1,section);
        query.setParameter(2,weight);
        query.setParameter(3,section);
        query.setParameter(4,courseplanId);

        query.executeUpdate();

    }

    @Override
    public List<CoursePlan> vagueQuery1(Object condition, String field) {
        String sql="select cp.* from course_plan cp,course c where cp.course_id=c.course_id and c.course_name like ?0";
        Query query=sessionFactory.getCurrentSession().createSQLQuery(sql);
        query.setParameter(0,"%"+condition+"%");

        List<Object[]> objects = query.list();
        //存放返回的集合
        List<CoursePlan> coursePlans=new ArrayList<>();
        for(Object[] objs:objects){
            int coursePlanId=Integer.parseInt(objs[0].toString());
            int courseId=Integer.parseInt(objs[1].toString());
            int weight=Integer.parseInt(objs[2].toString());
            int section=Integer.parseInt(objs[3].toString());

            CoursePlan coursePlan=new CoursePlan(coursePlanId,weight,section);
            coursePlan.setCourse(courseService.find(courseId));

            coursePlans.add(coursePlan);
        }

        return coursePlans;
    }

    @Override
    public Serializable findMaxId() {
        String hql="select MAX(courseplanId) from CoursePlan";
        List<Integer> ids = (List<Integer>) super.hibernateTemplate.find(hql);
        return ids.get(0);
    }
}
