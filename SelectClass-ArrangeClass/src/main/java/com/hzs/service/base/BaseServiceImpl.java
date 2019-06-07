package com.hzs.service.base;

import com.hzs.dao.base.IBaseDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author hzs
 * @description service-公共方法实现类
 * @date 2019/5/24 10:39
 */
public abstract class BaseServiceImpl<T> implements IBaseService<T> {
    @Override
    public T findByField(Object condition, String field) {
        System.out.println("我不实现的，只是为了你们子类不编译报错而已，我是BaseServiceImpl");
        return null;
    }

    @Override
    public void batchSave(List<T> entitys) {

    }

    @Override
    public void batchDelete(String major, String grade) {

    }

    @Override
    public List<Object> findByDistinct(Object field) {
        return null;
    }
}
