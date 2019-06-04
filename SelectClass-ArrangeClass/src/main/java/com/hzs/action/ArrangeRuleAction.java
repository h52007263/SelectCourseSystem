package com.hzs.action;

import com.hzs.action.base.BaseAction;
import com.hzs.model.ArrangeRule;
import com.hzs.service.IArrangeRuleService;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hezhensheng
 * @version 1.0
 * @description 排课规则的action实现类
 * @date 2019/6/3 19:19
 */

public class ArrangeRuleAction extends BaseAction<ArrangeRule> {
    private JSONObject jsonObject;
    //设置不转json的属性
    protected String[] strs=new String[]{};
    @Autowired
    private IArrangeRuleService arrangeRuleService;

    @Override
    public String save() {
        arrangeRuleService.save(getModel());
        return SUCCESS;
    }

    @Override
    public String delete() {
        arrangeRuleService.delete(getModel());
        return SUCCESS;
    }

    @Override
    public String update() {
        arrangeRuleService.update(getModel());
        return SUCCESS;
    }

    @Override
    public String find() {
        ArrangeRule course=arrangeRuleService.find(getModel().getRuleId());
        List<ArrangeRule> list=new ArrayList<>();
        list.add(course);
        jsonObject=responseJson(pb,list,strs);
        return SUCCESS;
    }

    @Override
    public String findAll() {
        List<ArrangeRule> list= arrangeRuleService.findAll();
        jsonObject=responseJson(pb,list,strs);
        return SUCCESS;
    }

    @Override
    public String vagueQuery() {
        HttpServletRequest request= ServletActionContext.getRequest();
        Object condition=request.getParameter("condition");
        String field=request.getParameter("field");
        jsonObject=responseJson(pb,arrangeRuleService.vagueQuery1(condition,field),strs);
        return SUCCESS;
    }

    public String pageQuery() {
        pb.setCurr(super.curr);
        pb.setLimit(super.pageSize);
        List<ArrangeRule> list = arrangeRuleService.pageQuery(pb);
        jsonObject=responseJson(pb,list,strs);
        return SUCCESS;
    }

    @Override
    public String findByField() {
        HttpServletRequest request=ServletActionContext.getRequest();
        String field = request.getParameter("field");
        Object condition=request.getParameter("condition");
        arrangeRuleService.findByField(condition,field);
        return SUCCESS;
    }

    public JSONObject getJsonObject() {
        return jsonObject;
    }

    public void setJsonObject(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }
}
