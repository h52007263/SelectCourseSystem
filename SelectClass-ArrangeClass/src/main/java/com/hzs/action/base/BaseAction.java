package com.hzs.action.base;

import com.hzs.model.PageBean;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @author hzs
 * @description action的公共方法
 * @date 2019/5/25 18:54
 */
public abstract class BaseAction<T> extends ActionSupport implements ModelDriven<T> {
    private T t;

    //1.分页的参数
    protected int curr;
    protected  int pageSize;

    public void setCurr(int curr) {
        this.curr = curr;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    //2.分页的模型
    protected PageBean<T> pb=new PageBean<>();

    public BaseAction(){
        //1.获得父类【BaseAction<T> 】的参数化类型【<T>、<T,V>】
        ParameterizedType genericSuperclass = (ParameterizedType) this.getClass().getGenericSuperclass();

        //2.获得类的参数化类型的数组
        Type[] types = genericSuperclass.getActualTypeArguments();

        //3.获取泛型类第一个参数的类型
        @SuppressWarnings("unchecked")
        Class<T> entityClass = (Class<T>) types[0];

        try {
            t = entityClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //增加
    public abstract String save();

    //删除
    public abstract String delete();

    //修改
    public abstract String update();

    //通过id查询
    public abstract String find();

    //查询所有
    public abstract String findAll();

    //任意字段的模糊查询
    public abstract String vagueQuery();

    //任意字段的等值查询
    public abstract String findByField();

    public JSONObject responseJson(PageBean<T> pb,List<T> list,String[] strs){
        //转换json的配置,排除分页的两个属性
        JsonConfig config=new JsonConfig();
        config.setExcludes(strs);
        pb.setData(list);
        pb.setCount(list.size());
        pb.setMsg("");
        pb.setCode(0);

        return JSONObject.fromObject(pb,config);
    }

    @Override
    public T getModel() {
        return t;
    }
}
