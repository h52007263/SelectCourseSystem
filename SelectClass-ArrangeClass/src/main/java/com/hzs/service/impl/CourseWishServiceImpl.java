package com.hzs.service.impl;

import com.hzs.dao.ICourseWishDao;
import com.hzs.model.CourseWish;
import com.hzs.model.PageBean;
import com.hzs.service.ICourseWishService;
import com.hzs.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * @author hezhensheng
 * @version 1.0
 * @description CourseWishServiceImpl
 * @date 2019/6/5 18:28
 */

@Service
@Transactional
public class CourseWishServiceImpl extends BaseServiceImpl<CourseWish> implements ICourseWishService {

    @Autowired
    private ICourseWishDao courseWishDao;

    @Override
    public void save(CourseWish entity) {
        courseWishDao.save(entity);
    }

    @Override
    public void delete(CourseWish entity) {
        courseWishDao.delete(entity);
    }

    @Override
    public void update(CourseWish entity) {
        courseWishDao.update(entity);
    }

    @Override
    public CourseWish find(Serializable id) {
        return courseWishDao.find(id);
    }

    @Override
    public List<CourseWish> findAll() {
        return courseWishDao.findAll();
    }

    @Override
    public List<CourseWish> pageQuery(PageBean<CourseWish> pb) {
        return courseWishDao.pageQuery(pb);
    }

    @Override
    public List<CourseWish> vagueQuery(String name) {
        return null;
    }

    @Override
    public List<CourseWish> vagueQuery1(Object condition, String field) {
        return courseWishDao.vagueQuery1(condition,field);
    }

    @Override
    public int findByMaxId(){
       return courseWishDao.findByMaxId();
    }
}
