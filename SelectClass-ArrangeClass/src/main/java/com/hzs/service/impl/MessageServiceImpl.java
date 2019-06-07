package com.hzs.service.impl;

import com.hzs.dao.IMessageDao;
import com.hzs.model.Message;
import com.hzs.model.PageBean;
import com.hzs.service.IMessageService;
import com.hzs.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * @author hezhensheng
 * @version 1.0
 * @description 消息的service实现类
 * @date 2019/6/4 15:02
 */

@Service
@Transactional
public class MessageServiceImpl extends BaseServiceImpl<Message> implements IMessageService {

    @Autowired
    private IMessageDao messageDao;

    @Override
    public void save(Message entity) {
        messageDao.save(entity);
    }

    @Override
    public void delete(Message entity) {
        messageDao.delete(entity);
    }

    @Override
    public void update(Message entity) {
        messageDao.update(entity);
    }

    @Override
    public Message find(Serializable id) {
        return messageDao.find(id);
    }

    @Override
    public List<Message> findAll() {
        return messageDao.findAll();
    }

    @Override
    public List<Message> pageQuery(PageBean<Message> pb) {
        return messageDao.pageQuery(pb);
    }

    @Override
    public List<Message> vagueQuery(String name) {
        return null;
    }

    @Override
    public List<Message> vagueQuery1(Object condition, String field) {
        return messageDao.vagueQuery1(condition,field);
    }
}
