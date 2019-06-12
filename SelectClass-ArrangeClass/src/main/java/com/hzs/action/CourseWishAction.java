package com.hzs.action;

import com.hzs.action.base.BaseAction;
import com.hzs.model.CourseWish;
import com.hzs.service.ICourseWishService;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author hezhensheng
 * @version 1.0
 * @description CourseWishAction
 * @date 2019/6/5 18:47
 */

public class CourseWishAction extends BaseAction<CourseWish> {

    private JSONObject jsonObject;
    //设置不转json的属性
    protected String[] strs=new String[]{"curr","limit","courses","coursePlan","courseWish"};
    @Autowired
    private ICourseWishService courseWishService;

    protected HttpServletRequest req= ServletActionContext.getRequest();

    @Override
    public String save() {
        courseWishService.save(getModel());
        return SUCCESS;
    }

    @Override
    public String delete() {
        courseWishService.delete(getModel());
        return SUCCESS;
    }

    @Override
    public String update() {
        courseWishService.update(getModel());
        return SUCCESS;
    }

    @Override
    public String find() {
        return null;
    }

    @Override
    public String findAll() {
        List<CourseWish> list= courseWishService.findAll();
        jsonObject=responseJson(pb,list,strs);
        return SUCCESS;
    }

    public String vagueQueryByMajor(){
        String major=req.getParameter("major");
        String grade=req.getParameter("grade");
        List<CourseWish> courseWishes = courseWishService.vagueQueryByMajor(major,grade);
        jsonObject=responseJson(pb,courseWishes,strs);
        return SUCCESS;
    }

    public String pageQuery() {
        pb.setCurr(super.curr);
        pb.setLimit(super.pageSize);
        List<CourseWish> list = courseWishService.pageQuery(pb);
        jsonObject=responseJson(pb,list,strs);
        return SUCCESS;
    }

    @Override
    public String vagueQuery() {
        return null;
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
