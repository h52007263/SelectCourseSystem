package demo.testModel;

import com.hzs.action.CoursePlanAction;
import com.hzs.model.Course;
import com.hzs.model.CoursePlan;
import com.hzs.service.ICoursePlanService;
import com.hzs.service.ICourseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author hezhensheng
 * @version 1.0
 * @description 课程和课程计划的一对一关系建立
 * @date 2019/5/30 13:55
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring.xml")
public class CoursePlan_Course {

    @Autowired
    private ICourseService courseService;

    @Autowired
    private ICoursePlanService coursePlanService;

    @Test
    public void testAction(){
        coursePlanService.findAll().forEach(coursePlan -> System.out.println(coursePlan));
    }

    @Test
    public void test2(){

//       Course course = courseService.findByField("数据结构","courseName");
//        System.out.println(course);

        CoursePlan coursePlan=new CoursePlan(2,2);
        coursePlan.setCourseplanId(1);

        coursePlanService.update(coursePlan,"数据结构");

    }

    @Test
    public void test1(){
        System.out.println("生成一对一关系");
    }
}
