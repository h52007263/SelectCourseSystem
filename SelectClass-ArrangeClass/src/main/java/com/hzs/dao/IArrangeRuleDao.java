package com.hzs.dao;

import com.hzs.dao.base.IBaseDao;
import com.hzs.model.ArrangeRule;

import java.util.List;

public interface IArrangeRuleDao extends IBaseDao<ArrangeRule> {
    //按照点赞数量降序查询
    public List<ArrangeRule> findAll();

}
