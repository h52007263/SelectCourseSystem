package demo.testModel;

import com.hzs.model.Course;
import com.hzs.service.ICourseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hezhensheng
 * @version 1.0
 * @description testCourse
 * @date 2019/6/5 15:20
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring.xml")
public class TestCourse {
    @Autowired
    private ICourseService courseService;

    //通过专业查询课程计划中没有加入的课程
    @Test
    public void testPlanCourse(){
       List<Course> courses = courseService.findNoCourseByMajor("计算机");
       courses.forEach(
               course -> System.out.println(course)
       );
    }

    @Test
    public void test8(){
        List<Course> courses = courseService.findByNameMajor("车辆工程","高等数学");
        courses.forEach(
                course -> System.out.println(course)
        );
    }

    @Test
    public void test7(){
        Course course = courseService.findByField("测试课程","courseName");
    }

    @Test
    public void test6(){
        List<Course> courses = courseService.findAll();
        courses.forEach(course -> System.out.println(course.getCourseWish().getCourse()));

    }

    @Test
    public void test5(){
//        courseService.findAllByThree("软件工程","2016","courseProperty","必修");
        courseService.findAllByThree("软件工程","2016","courseName","")
                .stream()
                .forEach(course -> System.out.println(course));

    }

    @Test
    public void test4(){
        //模糊查询
       List<Course> courses1 = courseService.vagueQuery1("必修","courseProperty");
       courses1.forEach(course -> System.out.println(course));

        //专业和年级查询
        List<Course> courses2 = courseService.findAllByMajor("软件工程","2016");
        courses2.forEach(course -> System.out.println(course));

        String field="courseProperty";

        for(int i=0;i<courses1.size();i++){
            for(int j=0;j<courses2.size();j++){
                if(courses1.get(i).getCourseProperty().equals(courses2.get(j).getCourseProperty())){

                }
            }
        }


    }

    @Test
    public void test3(){
        courseService.findByDistinct("grade")
                .stream()
                .forEach(
                        obj -> System.out.println(obj)
                );
    }

    @Test
    public void test1(){
        courseService.vagueQuery1("计算机","major").forEach(course -> System.out.println(course));
    }

    @Test
    public void test2(){
//        Map<String,Integer> map=new HashMap<>();
//        map.put("数据结构",1);
//        System.out.println(map.get("数据结构1"));

        List<Course> courseList = courseService.findAllByMajor("计算机","2016");
        courseList.stream()
                .forEach(course -> System.out.println(course));

    }

}
