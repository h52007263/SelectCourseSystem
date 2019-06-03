package com.hzs.action;

import com.hzs.action.base.BaseAction;
import com.hzs.model.Classroom;
import com.hzs.service.IClassroomService;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hezhensheng
 * @version 1.0
 * @description 教室的action实现类
 * @date 2019/6/1 20:35
 */

public class ClassroomAction extends BaseAction<Classroom> {

    private JSONObject jsonObject;

    //排除不转换为json的属性
    protected String[] strs=new String[]{};

    @Autowired
    private IClassroomService classroomService;

    @Override
    public String save() {
        classroomService.save(getModel());
        return SUCCESS;
    }

    @Override
    public String delete() {
        return null;
    }

    @Override
    public String update() {
        classroomService.update(getModel());
        return SUCCESS;
    }

    @Override
    public String find() {
        Classroom course=classroomService.find(getModel().getClassroomId());
        List<Classroom> list=new ArrayList<>();
        list.add(course);
        jsonObject=responseJson(pb,list,strs);
        return SUCCESS;
    }

    @Override
    public String findAll() {
        List<Classroom> list= classroomService.findAll();
        jsonObject=responseJson(pb,list,strs);
        return SUCCESS;
    }

    public String pageQuery() {
        pb.setCurr(super.curr);
        pb.setLimit(super.pageSize);
        List<Classroom> list = classroomService.pageQuery(pb);
        jsonObject=responseJson(pb,list,strs);
        return SUCCESS;
    }

    @Override
    public String vagueQuery() {
        HttpServletRequest request= ServletActionContext.getRequest();
        Object condition=request.getParameter("condition");
        String field=request.getParameter("field");
        jsonObject=responseJson(pb,classroomService.vagueQuery1(condition,field),strs);
        return SUCCESS;
    }

    //任意字段的等值查询
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
