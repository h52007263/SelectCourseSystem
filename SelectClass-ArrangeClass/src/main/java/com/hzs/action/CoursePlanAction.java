package com.hzs.action;

import com.hzs.action.base.BaseAction;
import com.hzs.model.CoursePlan;
import com.hzs.service.ICoursePlanService;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hezhensheng
 * @version 1.0
 * @description 课程计划的action实现类
 * @date 2019/5/30 18:13
 */


public class CoursePlanAction extends BaseAction<CoursePlan> {
    private JSONObject jsonObject;

    private HttpServletRequest request;

    //设置不转json的属性
    protected String[] strs=new String[]{"curr","limit","coursePlan","teacher","courseId"};

    @Autowired
    private ICoursePlanService coursePlanService;

    //增加课程计划【课程计划的courseId,通过设置course对象进行增加】
    @Override
    public String save() {
        request=ServletActionContext.getRequest();
        int courseId = Integer.parseInt(request.getParameter("courseId"));
        coursePlanService.save(getModel(),courseId);
        return SUCCESS;
    }

    @Override
    public String delete() {
        coursePlanService.delete(getModel());
        return SUCCESS;
    }

    @Override
    public String update() {
        request=ServletActionContext.getRequest();
        String courseName=request.getParameter("courseName");
        System.out.println(getModel());
        coursePlanService.update(getModel(),courseName);
        return SUCCESS;
    }

    @Override
    public String find() {
        CoursePlan coursePlan=coursePlanService.find(getModel().getCourseplanId());
        List<CoursePlan> list=new ArrayList<>();
        list.add(coursePlan);
        jsonObject=responseJson(pb,list,strs);
        return SUCCESS;
    }

    @Override
    public String findAll() {
        List<CoursePlan> list= coursePlanService.findAll();
        jsonObject=responseJson(pb,list,strs);
        return SUCCESS;
    }

    public String pageQuery() {
        pb.setCurr(super.curr);
        pb.setLimit(super.pageSize);
        List<CoursePlan> list = coursePlanService.pageQuery(pb);
        jsonObject=responseJson(pb,list,strs);
        return SUCCESS;
    }

    @Override
    public String vagueQuery() {
        HttpServletRequest request= ServletActionContext.getRequest();
        Object condition=request.getParameter("condition");
        String field=request.getParameter("field");
        jsonObject=responseJson(pb,coursePlanService.vagueQuery1(condition,field),strs);
        return SUCCESS;
    }

    @Override
    public String findByField() {
        request=ServletActionContext.getRequest();
        String field = request.getParameter("field");
        Object condition=request.getParameter("condition");
        coursePlanService.findByField(condition,field);
        return SUCCESS;
    }

    public JSONObject getJsonObject() {
        return jsonObject;
    }

    public void setJsonObject(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }
}
