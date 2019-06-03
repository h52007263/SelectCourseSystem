package demo;

import com.hzs.action.TestAction;
import com.hzs.util.ArrangeClassUtil;
import com.hzs.util.model.CourseCondition;
import org.junit.Test;

import java.util.*;

/**
 * @author hezhensheng
 * @version 1.0
 * @description 测试自动排课算法
 * @date 2019/6/1 21:16
 */

public class TestArrange {
    static int size=21;
    static protected String[] timeTable=new String[size];

    @Test
    public void test11(){
        TestAction testAction=new TestAction();
        testAction.findAll();
    }

    //测试排课结果
    @Test
    public void test5(){
        //课表数组
        String[] result=new String[21];
        Arrays.fill(result,"0");

        //设置需要排的课程和预条件
        List<CourseCondition> courses=getCourses();
        Map<Integer,String> map=getMap();

        //排课结果
        result=ArrangeClassUtil.arrange(courses,map);

        ArrangeClassUtil.pringTimeTable(result);

//        for(String s:result)
//            System.out.println(s);

    }

    //模拟排课前的设置
    private static Map<Integer,String> getMap(){
        Map<Integer,String> map=new HashMap<>();
        map.put(1,"专业设计");
        map.put(2,"专业设计");
        map.put(3,"专业设计");
        map.put(11,"没有课程");
        map.put(12,"没有课程");
        return map;
    }

    //模拟课程数据
    private static List<CourseCondition> getCourses(){

        //设置 weight join  time  day
//        Map<String,Integer> map1=getCondition(3,2,1,12,1);
//        Map<String,Integer> map2=getCondition(3,3,1,12,2);
//        Map<String,Integer> map3=getCondition(5,1,0,12,1);
//        Map<String,Integer> map4=getCondition(3,1,0,12,1);

        CourseCondition courseCondition1=new CourseCondition(1,"数据结构",4,3,0,12,1);
        CourseCondition courseCondition2=new CourseCondition(2,"计算机网络",3,2,0,12,2);
        CourseCondition courseCondition3=new CourseCondition(3,"计算机组成原理",2,1,0,12,1);
//        CourseCondition courseCondition4=new CourseCondition(4,"软件工程",4,1,0,12,1);
        CourseCondition courseCondition6=new CourseCondition(4,"C++",4,1,0,12,1);
        CourseCondition courseCondition7=new CourseCondition(4,"C语言",4,1,0,12,1);
        CourseCondition courseCondition8=new CourseCondition(4,"SSH",4,1,0,12,1);
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

    @Test
    public void test1(){
        initTimeTable();
        System.out.println(Arrays.toString(timeTable));
    }

    @Test
    public void test4(){
        List<Integer> list1=new ArrayList<>();
        list1.add(1);
        list1.add(2);

        List<Integer> list2=new ArrayList<>();
        list2.add(4);
        list2.add(3);

        list1.addAll(list2);

        System.out.println(list1);

    }

    @Test
    public void test3(){
        int val = (int)(Math.random() * timeTable.length);
        System.out.println(val);
    }

    //清空list集合
    @Test
    public void test2(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        System.out.println(list.size()==0);
        list.clear();
        System.out.println(list);
        System.out.println(list.size()==0);
    }

    //判断上午是否有教室

    //初始化课表
    public void initTimeTable(){
        Arrays.fill(timeTable,"0");
        timeTable[8]="1";
    }
}
