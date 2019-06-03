package demo.testService;

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
public class CoursePlan_Course_test {

    @Autowired
    private ICourseService courseService;

    @Autowired
    private ICoursePlanService coursePlanService;

    @Test
    public void test1(){

        Course course=courseService.find(1);
        System.out.println(course.getCoursePlan());

    }
}
