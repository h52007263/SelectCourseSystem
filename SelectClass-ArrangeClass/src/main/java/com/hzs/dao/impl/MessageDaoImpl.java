package com.hzs.dao.impl;

import com.hzs.dao.IMessageDao;
import com.hzs.dao.base.BaseDaoImpl;
import com.hzs.model.ArrangeRule;
import com.hzs.model.Message;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hezhensheng
 * @version 1.0
 * @description 消息的dao实现类
 * @date 2019/6/4 14:59
 */

@Repository
public class MessageDaoImpl extends BaseDaoImpl<Message> implements IMessageDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Message> findAll() {

        String sql="from Message order by messageId desc";

        Query query = sessionFactory.openSession().createQuery(sql);

        List<Message> messages=query.list();

        return messages;
    }
}
