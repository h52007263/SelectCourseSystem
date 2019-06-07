package com.hzs.service;

import com.hzs.model.CourseWish;
import com.hzs.service.base.IBaseService;

public interface ICourseWishService extends IBaseService<CourseWish> {
    public int findByMaxId();
}
