package com.hzs.action;

import com.hzs.action.base.BaseAction;
import com.hzs.model.Teacher;
import com.hzs.service.ITeacherService;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hezhensheng
 * @version 1.0
 * @description 教师的action实现类
 * @date 2019/5/29 23:21
 */
public class TeacherAction extends BaseAction<Teacher> {

    private JSONObject jsonObject;

    //排除转json的属性
    protected String[] strs=new String[]{"curr","limit","teacher","coursePlan"};

    @Autowired
    private ITeacherService teacherService;

    @Override
    public String save() {
        teacherService.save(getModel());
        return SUCCESS;
    }

    @Override
    public String delete() {
        teacherService.delete(getModel());
        return SUCCESS;
    }

    @Override
    public String update() {
        teacherService.update(getModel());
        return SUCCESS;
    }

    @Override
    public String find() {
        Teacher teacher=teacherService.find(getModel().getTeacherId());
        List<Teacher> list=new ArrayList<>();
        list.add(teacher);
        jsonObject=responseJson(pb,list,strs);
        return SUCCESS;
    }

    @Override
    public String findAll() {
        List<Teacher> list= teacherService.findAll();
        jsonObject=responseJson(pb,list,strs);
        return SUCCESS;
    }

    public String pageQuery() {
        pb.setCurr(super.curr);
        pb.setLimit(super.pageSize);
        List<Teacher> list = teacherService.pageQuery(pb);
        jsonObject=responseJson(pb,list,strs);
        return SUCCESS;
    }

    @Override
    public String vagueQuery() {
        HttpServletRequest request= ServletActionContext.getRequest();
        Object condition=request.getParameter("condition");
        String field=request.getParameter("field");
        jsonObject=responseJson(pb,teacherService.vagueQuery1(condition,field),strs);
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
