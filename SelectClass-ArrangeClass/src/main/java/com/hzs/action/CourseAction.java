package com.hzs.action;

import com.hzs.action.base.BaseAction;
import com.hzs.model.Course;
import com.hzs.service.ICourseService;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hezhensheng
 * @version 1.0
 * @description course的action实现类
 * @date 2019/5/30 9:54
 */

public class CourseAction extends BaseAction<Course> {
    private JSONObject jsonObject;
    //设置不转json的属性
    protected String[] strs=new String[]{"curr","limit","courses","course","coursePlan"};
    @Autowired
    private ICourseService courseService;

    @Override
    public String save() {
        courseService.save(getModel());
        return SUCCESS;
    }

    @Override
    public String delete() {
        courseService.delete(getModel());
        return SUCCESS;
    }

    @Override
    public String update() {
        courseService.update(getModel());
        return SUCCESS;
    }

    @Override
    public String find() {
        Course course=courseService.find(getModel().getCourseId());
        List<Course> list=new ArrayList<>();
        list.add(course);
        jsonObject=responseJson(pb,list,strs);
        return SUCCESS;
    }

    @Override
    public String findAll() {
        List<Course> list= courseService.findAll();
        jsonObject=responseJson(pb,list,strs);
        return SUCCESS;
    }

    public String pageQuery() {
        pb.setCurr(super.curr);
        pb.setLimit(super.pageSize);
        List<Course> list = courseService.pageQuery(pb);
        jsonObject=responseJson(pb,list,strs);
        return SUCCESS;
    }

    @Override
    public String vagueQuery() {
        HttpServletRequest request= ServletActionContext.getRequest();
        Object condition=request.getParameter("condition");
        String field=request.getParameter("field");
        jsonObject=responseJson(pb,courseService.vagueQuery1(condition,field),strs);
        return SUCCESS;
    }

    @Override
    public String findByField() {
        return null;
    }

    public JSONObject getJsonObject() {
        return jsonObject;
    }

    public void setJsonObject(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }
}
