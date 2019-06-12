package com.hzs.dao;

import com.hzs.dao.base.IBaseDao;
import com.hzs.model.ArrangeResult;

import java.util.List;
import java.util.Map;

public interface IArrangeResultDao extends IBaseDao<ArrangeResult> {
    //根据选课前的条件，专业，年级生成排课结果
    public List<ArrangeResult> generateResult(Map<Integer,String> map,String major,String grade);

    //按照专业和年级查询
    public List<ArrangeResult> findAllByMajor(String major,String grade);
}
