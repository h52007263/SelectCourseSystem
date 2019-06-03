package com.hzs.dao.base;

import com.hzs.model.PageBean;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @author hzs
 * @description 公共dao方法实现
 * @date 2019/5/24 10:06
 */
public class BaseDaoImpl<T> implements IBaseDao<T>{

    private Class<T> entityClass;   //泛型类

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    protected HibernateTemplate hibernateTemplate;  //子类和同一包下的类使用

    public BaseDaoImpl(){
        ParameterizedType pt= (ParameterizedType) this.getClass().getGenericSuperclass();
        //获取真实类型
        Type[] types=pt.getActualTypeArguments();
        entityClass= (Class<T>) types[0];
//        System.out.println("pt:  "+pt);
//        System.out.println("types:  "+types);
//        System.out.println("entityClass:    "+entityClass);
    }

    @Override
    public void save(T entity) {
        hibernateTemplate.save(entity);
    }

    @Override
    public void delete(T entity) {
        hibernateTemplate.delete(entity);
    }

    @Override
    public void update(T entity) {
        hibernateTemplate.update(entity);
    }

    @Override
    public T find(Serializable id) {
        return this.hibernateTemplate.get(entityClass,id);
    }

    @Override
    public List<T> findAll() {
        String hql="from "+entityClass.getSimpleName();
        return (List<T>) this.hibernateTemplate.find(hql);
    }

    @Override
    public void executeUpdate(String hql, Object... objs) {

    }

    @Override
    public List<T> pageQuery(PageBean<T> pb) {
        String hql="from "+entityClass.getSimpleName();
        Criteria criteria=sessionFactory.getCurrentSession().createCriteria(entityClass);
        int start=(pb.getCurr()-1)*pb.getLimit();
        criteria.setFirstResult(start);
        criteria.setMaxResults(pb.getLimit());
        List<T> list=criteria.list();
        return list;
    }

    @Override
    public List<T> vagueQuery(String name) {
        String hql="from "+ entityClass.getSimpleName() +" where username like ?0";
        Query query=sessionFactory.getCurrentSession().createQuery(hql);
        query.setString(0,"%"+name+"%");
        return query.list();
    }

    @Override
    public List<T> vagueQuery1(Object condition, String field) {
        String hql="from "+ entityClass.getSimpleName() +" where "+field+" like ?0";
        Query query=sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter(0,"%"+condition+"%");
        return query.list();
    }

    @Override
    public T findByField(Object condition,String field) {
        String hql="from "+entityClass.getSimpleName()+" where "+field+"=?0";
        Session session=sessionFactory.openSession();
        Query query=session.createQuery(hql);
        query.setParameter(0,condition);
        T t= (T) query.list().get(0);
        session.close();
        return t;
    }
}
