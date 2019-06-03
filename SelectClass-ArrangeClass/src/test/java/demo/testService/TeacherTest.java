package demo.testService;

import com.hzs.model.PageBean;
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
 * @description 测试教师的数据库操作
 * @date 2019/5/29 21:38
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring.xml")
public class TeacherTest {

    @Autowired
    private ITeacherService teacherService;

    @Test
    public void test1(){
        PageBean<Teacher> pb=new PageBean<>();
        pb.setCurr(1);
        pb.setLimit(2);
        teacherService.pageQuery(pb).forEach(teacher -> System.out.println(teacher));
    }
}
