package com.hzs.dao.impl;

import com.hzs.dao.IClassroomDao;
import com.hzs.dao.base.BaseDaoImpl;
import com.hzs.model.Classroom;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hezhensheng
 * @version 1.0
 * @description 教室的dao实现类
 * @date 2019/6/1 20:04
 */

@Repository
public class ClassroomDaoImpl extends BaseDaoImpl<Classroom> implements IClassroomDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Classroom> findAllAscByCap() {
        String hql="from Classroom order by capacity asc";
        Query query=sessionFactory.getCurrentSession().createQuery(hql);

        return query.list();
    }
}
