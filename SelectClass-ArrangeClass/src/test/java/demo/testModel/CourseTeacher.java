package demo.testModel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author hezhensheng
 * @version 1.0
 * @description 测试课程和教师的多对一关系生成
 * @date 2019/5/29 21:20
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring.xml")
public class CourseTeacher {
    @Test
    public void  test1(){
        System.out.println("加载spring的配置文件，扫描注解类，生成关系");
    }

}
