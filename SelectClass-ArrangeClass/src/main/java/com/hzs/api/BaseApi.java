package com.hzs.api;

import com.hzs.model.Admin;
import com.hzs.service.IAdminService;
import com.hzs.service.base.IBaseService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.Serializable;
import java.util.List;

/**
 * @author hzs
 * @description 接口的公共类
 * @date 2019/5/26 20:33
 */
public class BaseApi<T> {
    protected ApplicationContext context;
    protected IBaseService baseService;
    public BaseApi(){ }

    //增加
    public void save(T t){
        baseService.save(t);
    }

    //删除
    public void delete(T t){
        baseService.delete(t);
    }

    //修改
    public void update(T t){ baseService.update(t);}

    //查询所有
    public List<Admin> findAll(){ return baseService.findAll();}

    //查询
    public T findById(Serializable id){
        return (T) baseService.find(id);
    }

}
