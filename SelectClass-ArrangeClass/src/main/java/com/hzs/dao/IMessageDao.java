package com.hzs.dao;

import com.hzs.dao.base.IBaseDao;
import com.hzs.model.Message;

import java.util.List;

public interface IMessageDao extends IBaseDao<Message> {
    @Override
    List<Message> findAll();
}
