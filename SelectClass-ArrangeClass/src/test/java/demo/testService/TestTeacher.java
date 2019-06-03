package demo.testService;

import com.hzs.model.Teacher;
import com.hzs.service.ITeacherService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author hezhensheng
 * @version 1.0
 * @description 教师测试类
 * @date 2019/5/31 18:31
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring.xml")
public class TestTeacher {

    @Autowired
    private ITeacherService teacherService;

    @Test
    public void test1(){
        Teacher  teacher = teacherService.findByField("name","杨老师");
        System.out.println(teacher);
    }
}
