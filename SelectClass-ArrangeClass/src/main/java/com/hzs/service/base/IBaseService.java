package com.hzs.service.base;

import com.hzs.model.PageBean;

import java.io.Serializable;
import java.util.List;

public interface IBaseService<T> {
    //增
    public void save(T entity);

    //删
    public void delete(T entity);

    //修改
    public void update(T entity);

    //通过id查询
    public T find(Serializable id);

    //查询所有
    public List<T> findAll();

    //分页查询
    public List<T> pageQuery(PageBean<T> pb);

    //模糊查询
    public List<T> vagueQuery(String name);

    //任意字段的模糊查询
    public List<T> vagueQuery1(Object condition,String field);

    //任意字段的等值查询
    public T findByField(Object condition,String field);

    //批量增加
    public void batchSave(List<T> entitys);

    //批量删除，通过专业和年级
    public void batchDelete(String major,String grade);

    //任意字段的去重查询
    public List<Object> findByDistinct(Object field);

}
