package com.hzs.dao.impl;

import com.hzs.dao.IUserDao;
import com.hzs.dao.base.BaseDaoImpl;
import com.hzs.model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author hzs
 * @description 用户dao的实现类
 * @date 2019/5/23 13:39
 */
@Repository
@Transactional
public class UserDaoImpl extends BaseDaoImpl<User> implements IUserDao {
    //继承BaseDaoImpl中的公共实现方法，在IUserDao中重写自己独有的方法

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> getUserByAll() {
        String hql="from User";
        Query query=sessionFactory.getCurrentSession().createQuery(hql);
        List<User> users=query.list();
        return users;
    }

    @Override
    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public void deleteUser(User user) {

    }

    @Override
    public void updateUser(String hql,User user) {
        Query query=sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter(0,user.getName());
        query.setParameter(1,user.getAge());
        query.setParameter(2,user.getSex());
        query.setParameter(3,user.getId());

        query.executeUpdate();

    }

    @Override
    public List<User> getUserByPage(int curr, int limit) {
        String hql="from User";
        Criteria criteria=sessionFactory.getCurrentSession().createCriteria(User.class);
        criteria.setFirstResult(curr);
        criteria.setMaxResults(limit);
        List<User> users=criteria.list();
        return users;
    }


}
