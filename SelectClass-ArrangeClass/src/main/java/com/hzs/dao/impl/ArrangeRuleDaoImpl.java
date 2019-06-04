package com.hzs.dao.impl;

import com.hzs.dao.IArrangeRuleDao;
import com.hzs.dao.base.BaseDaoImpl;
import com.hzs.model.ArrangeRule;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.net.ServerSocket;
import java.util.List;

/**
 * @author hezhensheng
 * @version 1.0
 * @description 排课规则的dao类
 * @date 2019/6/3 19:00
 */

@Repository
public class ArrangeRuleDaoImpl extends BaseDaoImpl<ArrangeRule> implements IArrangeRuleDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<ArrangeRule> findAll() {

        String sql="from ArrangeRule order by point_num desc";

        Query query = sessionFactory.openSession().createQuery(sql);

        List<ArrangeRule> arrangeRules=query.list();

        return arrangeRules;
    }
}
