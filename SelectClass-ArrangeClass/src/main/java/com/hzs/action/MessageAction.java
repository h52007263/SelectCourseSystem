package com.hzs.action;

import com.hzs.action.base.BaseAction;
import com.hzs.model.Message;
import com.hzs.service.IMessageService;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author hezhensheng
 * @version 1.0
 * @description 消息类
 * @date 2019/6/4 15:10
 */

public class MessageAction extends BaseAction<Message> {
    private JSONObject jsonObject;
    //设置不转json的属性
    protected String[] strs=new String[]{"curr","limit","courses","course","coursePlan"};
    @Autowired
    private IMessageService messageService;

    public JSONObject getJsonObject() {
        return jsonObject;
    }

    public void setJsonObject(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    @Override
    public String save() {
        return null;
    }

    @Override
    public String delete() {
        messageService.delete(getModel());
        return SUCCESS;
    }

    @Override
    public String update() {
        return SUCCESS;
    }

    @Override
    public String find() {
        return null;
    }

    @Override
    public String findAll() {
        List<Message> list= messageService.findAll();
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
}
