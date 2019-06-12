package com.hzs.action;

import com.hzs.action.base.BaseAction;
import com.hzs.model.ArrangeResult;
import com.hzs.service.IArrangeResultService;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hezhensheng
 * @version 1.0
 * @description ArrangResultAction
 * @date 2019/6/7 11:02
 */

public class ArrangResultAction extends BaseAction<ArrangeResult> {
    private JSONObject jsonObject;
    //设置不转json的属性
    protected String[] strs=new String[]{"curr","limit"};
    @Autowired
    private IArrangeResultService arrangeResultService;

    @Override
    public String save() {
        return SUCCESS;
    }

    public String batchSave(){
        HttpServletRequest request=ServletActionContext.getRequest();
        String major = request.getParameter("major");
        String grade = request.getParameter("grade");
        System.out.println("专业和年级：  "+major+" "+grade);

        //删除当前专业和年级已安排的课程，后面重新排课
        arrangeResultService.batchDelete(major,grade);

        Map<Integer,String> map=new HashMap<Integer, String>();
        //获取排课结果
        List<ArrangeResult> list = arrangeResultService.generateResult(map,major,grade);

        arrangeResultService.batchSave(list);

        return SUCCESS;
    }

    @Override
    public String delete() {
        arrangeResultService.delete(getModel());
        return SUCCESS;
    }

    @Override
    public String update() {
        return null;
    }

    @Override
    public String find() {
        return null;
    }

    @Override
    public String findAll() {
        List<ArrangeResult> list= arrangeResultService.findAll();
        jsonObject=responseJson(pb,list,strs);
        return SUCCESS;
    }

    public String findAllByMajor(){
        HttpServletRequest request=ServletActionContext.getRequest();
        String major = request.getParameter("major");
        String grade = request.getParameter("grade");
        List<ArrangeResult> arrangeResults = arrangeResultService.findAllByMajor(major,grade);
        jsonObject=responseJson(pb,arrangeResults,strs);
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
