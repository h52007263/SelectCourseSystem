package com.hzs.util;

import com.hzs.model.ArrangeResult;
import com.hzs.model.Classroom;
import com.hzs.model.Course;
import com.hzs.model.CourseWish;
import com.hzs.util.model.CourseCondition;

import java.util.*;

/**
 * @author hezhensheng
 * @version 1.0
 * @description 自动排课算法工具类
 * @date 2019/6/6 15:16
 */
//select * from course_plan where courseplan_id in (select course_id from course where grade=2015 and major="计算机")
public class AutoArrangeUtil {
    //课表容量
    private static int size=21;
    //课表空间
    protected static String[] timeTable=new String[size];

    //存放上午空闲空间，一节课用完，就清空
    protected static List<Integer> morningList=new ArrayList<>();

    //存放下午空闲空间
    protected static List<Integer> afternoonList=new ArrayList<>();

    //初始化课表空间
    private static void initTimeTable(String[] timeTable,Map<Integer,String> map){
        Arrays.fill(timeTable,"0");
        Set<Integer> set = map.keySet();
        Iterator<Integer> iter=set.iterator();
        while(iter.hasNext()){
           int key = iter.next();
           String value=map.get(key);
           timeTable[key]=value;
        }
    }

    //模拟排课条件，暂时不用
    private static Map<String,Integer> getCondition(int weight,int section,int join,int ampm,int day){
        Map<String,Integer> map=new HashMap<>();
        map.put("weight",weight);
        map.put("join",join);
        map.put("ampm",ampm);
        map.put("day",day);
        map.put("section",section);
        return map;
    }

    //模拟课程数据
    private static List<CourseWish> getCourses(){

        //设置 weight join  time  day
//        Map<String,Integer> map1=getCondition(3,2,1,12,1);
//        Map<String,Integer> map2=getCondition(3,3,1,12,2);
//        Map<String,Integer> map3=getCondition(5,1,0,12,1);
//        Map<String,Integer> map4=getCondition(3,1,0,12,1);

        CourseWish courseCondition1=new CourseWish(1,"数据结构",4,3,0,12);
        CourseWish courseCondition2=new CourseWish(2,"计算机网络",3,2,0,12);
        CourseWish courseCondition3=new CourseWish(3,"计算机组成原理",2,1,0,12);
//        CourseCondition courseCondition4=new CourseCondition(4,"软件工程",4,1,0,12,1);
        CourseWish courseCondition6=new CourseWish(4,"C++",4,1,0,12);
        CourseWish courseCondition7=new CourseWish(4,"C语言",4,1,0,12);
        CourseWish courseCondition8=new CourseWish(4,"SSH",4,1,0,12);
        CourseWish courseCondition9=new CourseWish(4,"SSM",4,1,0,12);

        List<CourseWish> list=new ArrayList<>();
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

    //按照优先级排序，1，权重  2，课程节数  3，是否连堂
    private static List<CourseWish> getSortCourses(List<CourseWish> list){

        Collections.sort(list,CompareUtil.createComparator(-1,"weight","section","joins"));

        return list;
    }

    //对课程数据进行排课
    public static String[] arrange(List<CourseWish> list,Map<Integer,String > map){

        initTimeTable(timeTable,map);

        //获取优先级降序的  课程
        List<CourseWish> sortCourses=getSortCourses(list);

        for(CourseWish courseWish:sortCourses)
            place(courseWish);

        return timeTable;
    }

    //该课程是否可以被放置
    private static boolean place(CourseWish course){

        //课程名称
        String courseName=course.getCourseName();

        //课程多少节课
        int section = course.getSection();

        //期望上午/下午
        int ampm=course.getAmpm();

        //课程是否连堂
        int join = course.getJoins();

        //课程节数section=1，是否连堂join默认为0
        //判断课程表是否有空间
        if(Arrays.asList(timeTable).contains("0")){
            //判断上午是否存在section节课的空间
            if(ampm==12) {
                if(morning(section))        //如果存在满足的空间
                    fillCourse(ampm,section,join,courseName);     //判断是否连堂
                else {
                    System.out.println(courseName + "在 "+ampm+" 已经没有  "+section+"  个连续的空间了");
                    fillCourseBySeparate(section,courseName);
                }
            }
            //判断下午是否存在section节课的空间
            if(ampm==34) {
                if(afternoon(section))
                    fillCourse(ampm,section,join,courseName);
                else{
                    System.out.println(courseName + "在 "+ampm+" 已经没有  "+section+"  个连续的空间了");
                    fillCourseBySeparate(section,courseName);
                }
            }
        }
        return false;
    }

    //扫描上午是否有存放    section节课  的空间
    private static boolean morning(int section){
        morningList = scan(section,1);
        if(morningList.size()!=0)
            return true;
        return false;
    }

    //扫描上午是否有存放    section节课  的空间
    private static boolean afternoon(int section){
        afternoonList = scan(section,3);
        if(afternoonList.size()!=0)
            return true;
        return false;
    }

    //执行扫描
    private static List<Integer> scan(int section,int start){
        List<Integer> tmpList=new ArrayList<>();
        if(section==1){
            //避免数组越界，所以i=2
            for(int i=start+1;i<size;i+=4){
                if(timeTable[i-1] == "0")
                    tmpList.add(i-1);
                if(timeTable[i] == "0")
                    tmpList.add(i);
            }
        }
        else{
            for(int i=start+1;i<size;i+=4){
                if(timeTable[i-1] == "0" && timeTable[i] == "0"){
                    tmpList.add(i-1);
                    tmpList.add(i);
                }
            }
        }
        return tmpList;
    }

    //课程填充到满足条件的空间
    private static boolean fillCourse(int ampm,int section,int join,String courseName){
        if(ampm==12){
            //课程数大于1
            if(section>1){
                    if(morningList.size()>=2){
                        int position=randomMorning();
                        timeTable[morningList.get(position)]=courseName;
                        timeTable[morningList.get(position+1)]=courseName;
                    }
            }
            else{
                int position = randomMorning();
//                System.out.println("上午位置   "+position);
                timeTable[morningList.get(position)]=courseName;
                morningList.clear();
            }
        }
        else{
            if(section>1){
                    if(afternoonList.size()>=2){
                        int position=randomMorning();
                        timeTable[afternoonList.get(position)]=courseName;
                        timeTable[afternoonList.get(position+1)]=courseName;
                    }
            }
            else{
                int position = randomAfternoon();
//                System.out.println("下午位置   "+position);
                timeTable[afternoonList.get(position)]=courseName;
                afternoonList.clear();
            }
        }
        return true;
    }

    //section=2的课程没有连堂的空间，将他们填在不连堂的空间中
    private static boolean fillCourseBySeparate(int section,String courseName){
        morning(section);
        afternoon(section);
        //由于上午或者下午不存在满足连堂课的空间
        //所以合并 上午和下午 可用的空间
        morningList.addAll(afternoonList);

        int position=randomMorning();
        if(morningList.size()>0) {
            for (int i = 0; i < section; i++)
                timeTable[morningList.get(position + i)] = courseName;
        }
        //如果上午下午都没有连堂课的空间，则优先分配上午的课程，在分配下午的课程
        else{
            morning(1);
            afternoon(1);
            morningList.addAll(afternoonList);

            for (int i = 0; i < section; i++)
                timeTable[morningList.get(position + i)] = courseName;
            }
        return true;
    }

    //有多个空间满足时，按序分配
    private static int randomMorning(){
//        return (int)(Math.random() * morningList.size());
        return 0;
    }

    //有多个空间满足时，按序分配
    private static int randomAfternoon(){
//        return (int)(Math.random() * afternoonList.size());
        return 0;
    }

    //通过专业和年级定位
    //map courseName  capacity
    //课程时间，教室，容量，专业

    /**
     *
     * @param result
     * @param classrooms    教室
     * @param map           map<string，integer> 课程名和容量
     * @param mapTeacher    map<String,String>  课程对应的教师
     * @param major
     * @param grade
     * @return
     */
    public static List<ArrangeResult> fillRoom(String[] result, List<Classroom> classrooms, Map<String,Integer> map,Map<String,String> mapTeacher, String major, int grade){
        List<ArrangeResult> results=new ArrayList<>();
        ArrangeResult arrangeResult=null;
        String roomName="";
        System.out.println("map的长度是："+map.size());
        System.out.println(map);
        for(int i=1;i<result.length;i++){
            if(result[i]=="0" || result[i]=="没有课程")
                continue;
            arrangeResult=new ArrangeResult();
            arrangeResult.setCourseName(result[i]);
            arrangeResult.setUseTime(i+"");
            arrangeResult.setGrade(grade);
            arrangeResult.setMajor(major);
            arrangeResult.setTeacherName(mapTeacher.get(result[i]));

            int capacity = map.get(result[i]).intValue();

            for(int j=0;j<classrooms.size();j+=2){
                if(i>1 && result[i].equals(result[i-1])) {
                    arrangeResult.setRoomName(roomName);
                    results.add(arrangeResult);
                    break;
                }
                if(capacity<=classrooms.get(j).getCapacity()){
                    roomName=classrooms.get(j+randomNum()).getName();
                    arrangeResult.setRoomName(roomName);
                    results.add(arrangeResult);
                    break;
                }
            }
        }

        return results;
    }

    private static int randomNum(){
        int num = (int)(Math.random()*2);
        return num;
    }

    public static void main(String[] args) {

        System.out.println(randomNum());

//        String[] result=new String[21];
//        Arrays.fill(result,"0");
//
//        //权重最高的特殊的课程
//        Map<Integer,String> map=new HashMap<>();
//        map.put(1,"专业设计");
//        map.put(2,"专业设计");
//        map.put(3,"专业设计");
//        map.put(11,"没有课程");
//        map.put(12,"没有课程");
//
//        //开始排课
//        result=arrange(getCourses(),map);
//        //排课结果
//        pringTimeTable(result);


    }

    public static void pringTimeTable(String[] timeTable1){

        System.out.println("周一课程");
        for(int i=1;i<5;i++){
            System.out.print(timeTable1[i]+"\t");
        }

        System.out.println("\n周二课程");
        for(int i=5;i<9;i++){
            System.out.print(timeTable1[i]+"\t");
        }

        System.out.println("\n周三课程");
        for(int i=9;i<13;i++){
            System.out.print(timeTable1[i]+"\t");
        }

        System.out.println("\n周四课程");
        for(int i=13;i<17;i++){
            System.out.print(timeTable1[i]+"\t");
        }

        System.out.println("\n周五课程");
        for(int i=17;i<21;i++){
            System.out.print(timeTable1[i]+"\t");
        }

    }

}
