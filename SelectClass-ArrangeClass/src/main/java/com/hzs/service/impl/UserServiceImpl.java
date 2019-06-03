package com.hzs.service.impl;

import com.hzs.dao.IUserDao;
import com.hzs.model.User;
import com.hzs.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hzs
 * @description 用户service类的实现
 * @date 2019/5/23 13:45
 */
@Service(value = "userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void deleteUser(User user) {

    }

    @Override
    public void updateUser(String hql,User user) {
        userDao.updateUser(hql,user);
    }

    @Override
    public List<User> getUserByAll() {
        List<User> users = userDao.getUserByAll();
        return users;
    }

    @Override
    public List<User> getUserByPage(int curr, int limit) {
        List<User> users=userDao.getUserByPage(curr,limit);
        return users;
    }
}
