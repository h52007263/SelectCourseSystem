package com.hzs.action;

import com.hzs.model.PageBean;
import com.hzs.model.User;
import com.hzs.service.IUserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import net.sf.json.JSONObject;
import net.sf.json.JSONString;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hzs
 * @description action层：用户的实现类
 * @date 2019/5/23 13:52
 */
@Controller
@Scope("prototype")
public class UserAction extends ActionSupport implements ModelDriven<User> {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private String result;
    private User user;
    private JSONObject jsonObject;

    @Autowired
    private IUserService userService;

    public String pageQuery(){
        request=ServletActionContext.getRequest();
        Integer curr=Integer.parseInt(request.getParameter("curr"));
        Integer limit=Integer.parseInt(request.getParameter("limit"));
        System.out.println(curr+" "+limit);

        PageBean pb=new PageBean();
        List<User> users=userService.getUserByPage((curr-1)*limit,limit);
        pb.setCode(0);
        pb.setMsg("");
        pb.setCount(users.size());
        pb.setData(users);

        jsonObject=JSONObject.fromObject(pb);
        result=jsonObject.toString();
        System.out.println(jsonObject);

        return SUCCESS;
    }

    public String getUserByAll() throws IOException {
        PageBean pb=new PageBean();
        List<User> users = userService.getUserByAll();
           pb.setCode(0);
           pb.setMsg("");
           pb.setCount(users.size());
           pb.setData(users);

       jsonObject=JSONObject.fromObject(pb);
       result=jsonObject.toString();
       System.out.println(jsonObject);

//        HttpServletResponse response= ServletActionContext.getResponse();
//        response.setHeader("content-type","text/json;charset=utf-8");
//        response.getWriter().write(jsonObject.toString());

        return SUCCESS;
    }

    public String addUser1() throws IOException {
        System.out.println(getModel());
//        userService.addUser(user);
        return NONE;
    }

    public String addUser() throws IOException {
        //1.获取request对象，用于获取参数的值
        request = ServletActionContext.getRequest();
        //2.为user赋值
        user=new User();
        String name=request.getParameter("name");
        Integer age=Integer.parseInt(request.getParameter("age"));
        String sex=request.getParameter("sex");
        user.setName(name);
        user.setAge(age);
        user.setSex(sex);
        //3.调用service的addUser
        userService.addUser(user);

        //4.响应
        response=ServletActionContext.getResponse();
        response.getWriter().write("success");

        return  NONE;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public JSONObject getJsonObject() {
        return jsonObject;
    }

    public void setJsonObject(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public User getModel() {
        return user;
    }
}
