package com.hzs.service;

import com.hzs.model.Classroom;
import com.hzs.service.base.IBaseService;

import java.util.List;

public interface IClassroomService extends IBaseService<Classroom> {
    //按容量升序查询教室
    public List<Classroom> findAllAscByCap();
}
