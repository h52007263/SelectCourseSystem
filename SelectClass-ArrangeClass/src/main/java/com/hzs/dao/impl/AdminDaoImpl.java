package com.hzs.dao.impl;

import com.hzs.dao.IAdminDao;
import com.hzs.dao.IUserDao;
import com.hzs.dao.base.BaseDaoImpl;
import com.hzs.model.Admin;
import org.springframework.stereotype.Repository;

/**
 * @author hzs
 * @description dao-管理员实现类
 * @date 2019/5/24 10:37
 */
@Repository
public class AdminDaoImpl extends BaseDaoImpl<Admin> implements IAdminDao {
}
