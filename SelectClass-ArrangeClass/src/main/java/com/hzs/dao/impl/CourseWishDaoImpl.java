package com.hzs.dao.impl;

import com.hzs.dao.ICourseWishDao;
import com.hzs.dao.base.BaseDaoImpl;
import com.hzs.model.CourseWish;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hezhensheng
 * @version 1.0
 * @description CourseWishDaoImpl
 * @date 2019/6/5 18:16
 */

@Repository
public class CourseWishDaoImpl extends BaseDaoImpl<CourseWish> implements ICourseWishDao {
    @Override
    public Integer findByMaxId() {
        String hql="select MAX(courseId) from CourseWish";
        List<Integer> ids = (List<Integer>) hibernateTemplate.find(hql);
        return ids.get(0);
    }
}
