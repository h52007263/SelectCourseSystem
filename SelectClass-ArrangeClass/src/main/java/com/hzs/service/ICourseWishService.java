package com.hzs.service;

import com.hzs.model.CourseWish;
import com.hzs.service.base.IBaseService;

import java.util.List;

public interface ICourseWishService extends IBaseService<CourseWish> {
    public int findByMaxId();

    //按照专业和年级查询课程意向
    public List<CourseWish> vagueQueryByMajor(String major, String grade);

    //单纯的更新
    public void updatePure(CourseWish courseWish);
}
