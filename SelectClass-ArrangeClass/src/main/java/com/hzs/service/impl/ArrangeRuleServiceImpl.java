package com.hzs.service.impl;

import com.hzs.dao.IArrangeRuleDao;
import com.hzs.model.ArrangeRule;
import com.hzs.model.PageBean;
import com.hzs.service.IArrangeRuleService;
import com.hzs.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * @author hezhensheng
 * @version 1.0
 * @description 排课规则的service实现类
 * @date 2019/6/3 19:15
 */

@Service
@Transactional
public class ArrangeRuleServiceImpl extends BaseServiceImpl<ArrangeRule> implements IArrangeRuleService {

    @Autowired
    private IArrangeRuleDao arrangeRuleDao;

    @Override
    public void save(ArrangeRule entity) {
        arrangeRuleDao.save(entity);
    }

    @Override
    public void delete(ArrangeRule entity) {
        arrangeRuleDao.delete(entity);
    }

    @Override
    public void update(ArrangeRule entity) {
        arrangeRuleDao.update(entity);
    }

    @Override
    public ArrangeRule find(Serializable id) {
        return arrangeRuleDao.find(id);
    }

    @Override
    public List<ArrangeRule> findAll() {
        return arrangeRuleDao.findAll();
    }

    @Override
    public List<ArrangeRule> pageQuery(PageBean<ArrangeRule> pb) {
        return arrangeRuleDao.pageQuery(pb);
    }

    @Override
    public List<ArrangeRule> vagueQuery(String name) {
        return null;
    }

    @Override
    public List<ArrangeRule> vagueQuery1(Object condition, String field) {
        return arrangeRuleDao.vagueQuery1(condition,field);
    }
}
