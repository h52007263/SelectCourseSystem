package demo.testService;

import com.hzs.service.ICourseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author hezhensheng
 * @version 1.0
 * @description 课程的业务操作测试
 * @date 2019/5/30 8:36
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring.xml")
public class TestCourse {

    @Autowired
    private ICourseService courseService;

    @Test
    public void test1(){
        System.out.println(courseService.find(1).getTeacher());
    }
}
