package com.hzs.service.impl;


import com.hzs.dao.IClassroomDao;
import com.hzs.model.Classroom;
import com.hzs.model.PageBean;
import com.hzs.service.IClassroomService;
import com.hzs.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.io.Serializable;
import java.util.List;

/**
 * @author hezhensheng
 * @version 1.0
 * @description 教室的dao实现类
 * @date 2019/6/1 20:07
 */

@Service
@Transactional
public class ClassroomServiceImpl extends BaseServiceImpl<Classroom> implements IClassroomService {

    @Autowired
    private IClassroomDao classroomDao;

    @Override
    public void save(Classroom entity) {
        classroomDao.save(entity);
    }

    @Override
    public void delete(Classroom entity) {
        classroomDao.delete(entity);
    }

    @Override
    public void update(Classroom entity) {
        classroomDao.update(entity);
    }

    @Override
    public Classroom find(Serializable id) {
        return classroomDao.find(id);
    }

    @Override
    public List<Classroom> findAll() {
        return classroomDao.findAll();
    }

    @Override
    public List<Classroom> pageQuery(PageBean<Classroom> pb) {
        return classroomDao.pageQuery(pb);
    }

    @Override
    public List<Classroom> vagueQuery(String name) {
        return null;
    }

    @Override
    public List<Classroom> vagueQuery1(Object condition, String field) {
        return classroomDao.vagueQuery1(condition,field);
    }

    @Override
    public List<Classroom> findAllAscByCap() {
        return classroomDao.findAllAscByCap();
    }
}
