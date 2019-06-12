package com.hzs.service.impl;

import com.hzs.dao.IArrangeResultDao;
import com.hzs.model.ArrangeResult;
import com.hzs.model.PageBean;
import com.hzs.service.IArrangeResultService;
import com.hzs.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author hezhensheng
 * @version 1.0
 * @description ArrangeResultServiceImpl
 * @date 2019/6/6 23:14
 */

@Service
@Transactional
public class ArrangeResultServiceImpl extends BaseServiceImpl<ArrangeResult> implements IArrangeResultService {

    @Autowired
    private IArrangeResultDao arrangeResultDao;

    @Override
    public List<ArrangeResult> generateResult(Map<Integer, String> map, String major, String grade) {
        return arrangeResultDao.generateResult(map,major,grade);
    }

    @Override
    public List<ArrangeResult> findAllByMajor(String major, String grade) {
        return arrangeResultDao.findAllByMajor(major,grade);
    }

    @Override
    public void save(ArrangeResult entity) {
        arrangeResultDao.save(entity);
    }

    @Override
    public void delete(ArrangeResult entity) {
        arrangeResultDao.delete(entity);
    }

    @Override
    public void update(ArrangeResult entity) {
        arrangeResultDao.update(entity);
    }

    @Override
    public ArrangeResult find(Serializable id) {
        return arrangeResultDao.find(id);
    }

    @Override
    public List<ArrangeResult> findAll() {
        return arrangeResultDao.findAll();
    }

    @Override
    public List<ArrangeResult> pageQuery(PageBean<ArrangeResult> pb) {
        return arrangeResultDao.pageQuery(pb);
    }

    @Override
    public List<ArrangeResult> vagueQuery(String name) {
        return null;
    }

    @Override
    public List<ArrangeResult> vagueQuery1(Object condition, String field) {
        return arrangeResultDao.vagueQuery1(condition,field);
    }

    @Override
    public void batchSave(List<ArrangeResult> entitys) {
        arrangeResultDao.batchSave(entitys);
    }

    @Override
    public void batchDelete(String major, String grade) {
        arrangeResultDao.batchDelete(major, grade);
    }
}
