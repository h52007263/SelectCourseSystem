package demo.testModel;

import com.hzs.model.Course;
import com.hzs.service.ICourseService;
import com.hzs.service.ITeacherService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author hezhensheng
 * @version 1.0
 * @description testCourse
 * @date 2019/6/5 15:20
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring.xml")
public class TestTeacher {

    @Autowired
    private ITeacherService teacherService;

    @Test
    public void test1(){
        System.out.println( teacherService.find(1001));
    }

}
