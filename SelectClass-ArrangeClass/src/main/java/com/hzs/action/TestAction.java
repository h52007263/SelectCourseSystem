package com.hzs.action;

import com.hzs.action.base.BaseAction;
import com.hzs.util.ArrangeClassUtil;
import com.hzs.util.model.CourseCondition;
import net.sf.json.JSONObject;

import java.util.*;

/**
 * @author hezhensheng
 * @version 1.0
 * @description 测试排课数据
 * @date 2019/6/2 16:34
 */

public class TestAction extends BaseAction<CourseCondition> {

    private JSONObject jsonObject;

    protected String[] strs=new String[]{"curr","limit"};

    @Override
    public String save() {
        return null;
    }

    @Override
    public String delete() {
        return null;
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

        String[] result=new String[21];
        Arrays.fill(result,"0");

        result=ArrangeClassUtil.arrange(gainCourses(),gainMap());
        List<String> resultList=Arrays.asList(result);

        System.out.println(gainMap().size());
        System.out.println(gainCourses().size());

        List<CourseCondition> list=new ArrayList<>();
        for(int i=1;i<result.length;i++){
            if(result[i]!="0") {
                CourseCondition courseCondition = new CourseCondition();
                courseCondition.setTime(i);
                courseCondition.setCourseName(result[i]);
                list.add(courseCondition);
            }
        }
        System.out.println(list.size());
        jsonObject=responseJson(pb,list,strs);
        System.out.println(jsonObject);
        return SUCCESS;
    }

    //模拟排课前的设置
    private static Map<Integer,String> gainMap(){
        Map<Integer,String> map=new HashMap<>();
        map.put(1,"专业设计");
        map.put(2,"专业设计");
        map.put(3,"专业设计");
        map.put(11,"没有课程");
        map.put(12,"没有课程");
        return map;
    }

    //模拟课程数据
    private static List<CourseCondition> gainCourses(){

        //设置 weight join  time  day
//        Map<String,Integer> map1=getCondition(3,2,1,12,1);
//        Map<String,Integer> map2=getCondition(3,3,1,12,2);
//        Map<String,Integer> map3=getCondition(5,1,0,12,1);
//        Map<String,Integer> map4=getCondition(3,1,0,12,1);

        CourseCondition courseCondition1=new CourseCondition(1,"数据结构",4,2,0,12,1);
        CourseCondition courseCondition2=new CourseCondition(2,"计算机网络",3,2,0,34,2);
        CourseCondition courseCondition3=new CourseCondition(3,"计算机组成原理",2,1,0,34,1);
//        CourseCondition courseCondition4=new CourseCondition(4,"软件工程",4,1,0,12,1);
        CourseCondition courseCondition6=new CourseCondition(4,"C++",4,1,0,12,1);
        CourseCondition courseCondition7=new CourseCondition(4,"C语言",4,1,0,12,1);
        CourseCondition courseCondition8=new CourseCondition(4,"SSH",4,1,0,34,1);
        CourseCondition courseCondition9=new CourseCondition(4,"SSM",4,1,0,12,1);

        List<CourseCondition> list=new ArrayList<>();
        list.add(courseCondition3);
        list.add(courseCondition2);
        list.add(courseCondition1);
//        list.add(courseCondition4);
        list.add(courseCondition6);
        list.add(courseCondition7);
        list.add(courseCondition8);
        list.add(courseCondition9);

        return list;
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
