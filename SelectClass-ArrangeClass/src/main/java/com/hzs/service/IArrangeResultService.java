package com.hzs.service;

import com.hzs.model.ArrangeResult;
import com.hzs.service.base.IBaseService;

import java.util.List;
import java.util.Map;

public interface IArrangeResultService extends IBaseService<ArrangeResult> {
    //根据选课前的条件，专业，年级生成排课结果
    public List<ArrangeResult> generateResult(Map<Integer,String> map, String major, String grade);
}
