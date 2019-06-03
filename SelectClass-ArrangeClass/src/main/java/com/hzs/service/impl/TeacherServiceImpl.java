package com.hzs.service.impl;

import com.hzs.dao.ITeacherDao;
import com.hzs.dao.impl.TeacherDaoImpl;
import com.hzs.model.PageBean;
import com.hzs.model.Teacher;
import com.hzs.service.ITeacherService;
import com.hzs.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * @author hezhensheng
 * @version 1.0
 * @description 教师的service实现类
 * @date 2019/5/29 21:33
 */

@Service
@Transactional
public class TeacherServiceImpl extends BaseServiceImpl<Teacher> implements ITeacherService {

    @Autowired
    private ITeacherDao teacherDao;

    @Override
    public void save(Teacher entity) {
        teacherDao.save(entity);
    }

    @Override
    public void delete(Teacher entity) {
        teacherDao.delete(entity);
    }

    @Override
    public void update(Teacher entity) {
        teacherDao.update(entity);
    }

    @Override
    public Teacher find(Serializable id) {
        return teacherDao.find(id);
    }

    @Override
    public List<Teacher> findAll() {
        return teacherDao.findAll();
    }

    @Override
    public List<Teacher> pageQuery(PageBean<Teacher> pb) {
        return teacherDao.pageQuery(pb);
    }

    @Override
    public List<Teacher> vagueQuery(String name) {
        return null;
    }

    @Override
    public List<Teacher> vagueQuery1(Object condition, String field) {
        return teacherDao.vagueQuery1(condition,field);
    }
}
