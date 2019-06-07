package demo;

import com.hzs.action.TestAction;
import com.hzs.model.ArrangeResult;
import com.hzs.model.Classroom;
import com.hzs.model.Course;
import com.hzs.model.CourseWish;
import com.hzs.service.IClassroomService;
import com.hzs.service.ICourseService;
import com.hzs.service.ICourseWishService;
import com.hzs.util.ArrangeClassUtil;
import com.hzs.util.AutoArrangeUtil;
import com.hzs.util.CompareUtil;
import com.hzs.util.model.CourseCondition;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

/**
 * @author hezhensheng
 * @version 1.0
 * @description 测试自动排课算法
 * @date 2019/6/1 21:16
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring.xml")
public class TestArrange {

    @Autowired
    private ICourseWishService courseWishService;

    @Autowired
    private IClassroomService classroomService;

    @Autowired
    private ICourseService courseService;

    static int size=21;
    static protected String[] timeTable=new String[size];

    @Test
    public void test13(){
        String major="软件工程";
        String grade="2016";
        //查询排的课程
        List<Course> courses1=courseService.findAllByMajor(major,grade);
        //得到课程的容量
        Map<String,Integer> map1=new HashMap<>();
        for(Course course:courses1)
            map1.put(course.getCourseName(),course.getCapacity());

        int capacity = map1.get("数据结构");

        System.out.println(capacity);
    }

    @Test
    public void test12(){

        String major="软件工程";
        String grade="2016";
        List<CourseWish> courses=courseWishService.findAll();
        String[] result=new String[21];
        Arrays.fill(result,"0");

        //权重最高的特殊的课程
        Map<Integer,String> map=new HashMap<>();
//        map.put(1,"专业设计");
//        map.put(2,"专业设计");
//        map.put(3,"专业设计");
        map.put(11,"没有课程");
        map.put(12,"没有课程");

        //获取选课结果  课程时间 课程名称
        result=AutoArrangeUtil.arrange(courses,map);

        //输出结果
        AutoArrangeUtil.pringTimeTable(result);

        //String[] wishs, List<Classroom> classrooms, Map<String,Integer> map, String major, int grade

        //查询教室
        List<Classroom> classrooms=classroomService.findAllAscByCap();
        //查询排的课程
        List<Course> courses1=courseService.findAllByMajor(major,grade);
        //得到课程的容量
        Map<String,Integer> map1=new HashMap<>();
        //得到课程的教师
        Map<String,String> mapTeacher=new HashMap<>();
        for(Course course:courses1)
            map1.put(course.getCourseName(),course.getCapacity());
        for(Course course:courses1){
            mapTeacher.put(course.getCourseName(),course.getTeacher().getName());
        }
        //获取最后的结果
        List<ArrangeResult> resultList = AutoArrangeUtil.fillRoom(result,classrooms,map1,mapTeacher,major,Integer.parseInt(grade));

        resultList.stream().forEach(
                arrangeResult -> System.out.println(arrangeResult)
        );

    }

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
