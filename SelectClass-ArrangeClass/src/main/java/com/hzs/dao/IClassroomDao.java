package com.hzs.dao;

import com.hzs.dao.base.IBaseDao;
import com.hzs.model.Classroom;

import java.util.List;

public interface IClassroomDao extends IBaseDao<Classroom> {
    //按容量升序查询教室
    public List<Classroom> findAllAscByCap();
}
