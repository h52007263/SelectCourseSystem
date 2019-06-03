package com.hzs.action;

import com.hzs.action.base.BaseAction;
import com.hzs.model.Admin;
import com.hzs.model.PageBean;
import com.hzs.service.IAdminService;
import com.hzs.service.impl.AdminServiceImpl;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hzs
 * @description 管理员的action实现类
 * @date 2019/5/25 18:54
 */
public class AdminAction extends BaseAction<Admin> {

    private JSONObject jsonObject;

    protected String[] strs=new String[]{"curr","limit"};

    @Autowired
    private IAdminService adminService;

    public String test() {
        System.out.println("获取的请求参数："+super.getModel());
        return NONE;
    }


    @Override
    public String save() {
        adminService.save(getModel());
        return SUCCESS;
    }

    @Override
    public String delete() {
        adminService.delete(getModel());
        return SUCCESS;
    }

    @Override
    public String update() {
        adminService.update(getModel());
        return SUCCESS;
    }

    @Override
    public String find() {
        Admin admin = (Admin) adminService.find(getModel().getId());
        List<Admin> list=new ArrayList<>();
        list.add(admin);
        jsonObject=responseJson(pb,list,strs);
        return SUCCESS;
    }

    @Override
    public String findAll() {
        jsonObject=responseJson(pb,adminService.findAll(),strs);
        return SUCCESS;
    }

    @Override
    public String vagueQuery() {
        HttpServletRequest request= ServletActionContext.getRequest();
        Object condition=request.getParameter("condition");
        String field=request.getParameter("field");
        jsonObject=responseJson(pb,adminService.vagueQuery1(condition,field),strs);
        return SUCCESS;
    }

    @Override
    public String findByField() {
        return null;
    }

    public String pageQuery() {
        pb.setCurr(super.curr);
        pb.setLimit(super.pageSize);
        List<Admin> list = adminService.pageQuery(pb);
        jsonObject=responseJson(pb,list,strs);
        return SUCCESS;
    }

    public void setJsonObject(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    public JSONObject getJsonObject() {
        return jsonObject;
    }
}
