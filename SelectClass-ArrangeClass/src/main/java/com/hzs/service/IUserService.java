package com.hzs.service;

import com.hzs.model.User;

import java.util.List;

public interface IUserService {

    public void addUser(User user);

    public void deleteUser(User user);

    public void updateUser(String hql,User user);

    public List<User> getUserByAll();

    public List<User> getUserByPage(int curr,int limit);

}
