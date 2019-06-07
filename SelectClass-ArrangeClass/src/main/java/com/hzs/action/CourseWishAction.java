package com.hzs.action;

import com.hzs.action.base.BaseAction;
import com.hzs.model.CourseWish;
import com.hzs.service.ICourseWishService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

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
    protected String[] strs=new String[]{"curr","limit","courses","course","coursePlan"};
    @Autowired
    private ICourseWishService courseWishService;

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
