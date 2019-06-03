package com.hzs.service.impl;

import com.hzs.dao.IAdminDao;
import com.hzs.model.Admin;
import com.hzs.model.PageBean;
import com.hzs.service.IAdminService;
import com.hzs.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * @author hzs
 * @description service-管理员的业务方法实现类
 * @date 2019/5/24 10:41
 */

@Service
@Transactional
public class AdminServiceImpl extends BaseServiceImpl<Admin> implements IAdminService {

    @Autowired
    private IAdminDao adminDao;

    @Override
    public void save(Admin entity) {
        adminDao.save(entity);
    }

    @Override
    public void delete(Admin entity) {
        adminDao.delete(entity);
    }

    @Override
    public void update(Admin entity) {
        adminDao.update(entity);
    }

    @Override
    public Admin find(Serializable id) {
        return adminDao.find(id);
    }

    @Override
    public List<Admin> findAll() {
        return adminDao.findAll();
    }

    @Override
    public List<Admin> pageQuery(PageBean<Admin> pb) {
        return adminDao.pageQuery(pb);
    }

    @Override
    public List<Admin> vagueQuery(String name) {
        return adminDao.vagueQuery(name);
    }

    @Override
    public List<Admin> vagueQuery1(Object condition, String field) {
        return adminDao.vagueQuery1(condition,field);
    }
}
