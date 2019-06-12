package com.hzs.dao;

import com.hzs.dao.base.IBaseDao;
import com.hzs.model.CourseWish;

import java.util.List;

public interface ICourseWishDao extends IBaseDao<CourseWish> {

    //按照专业和年级查询课程意向
    public List<CourseWish> vagueQueryByMajor(String major, String grade);

    //单纯的更新
    public void updatePure(CourseWish courseWish);

}
