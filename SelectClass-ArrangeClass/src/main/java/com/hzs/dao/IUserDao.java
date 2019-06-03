package com.hzs.dao;

import com.hzs.dao.base.IBaseDao;
import com.hzs.model.User;

import java.util.List;

public interface IUserDao extends IBaseDao<User> {
    public List<User> getUserByAll();

    public void addUser(User user);

    public void deleteUser(User user);

    public void updateUser(String hql,User user);

    public List<User> getUserByPage(int curr,int limit);
}
