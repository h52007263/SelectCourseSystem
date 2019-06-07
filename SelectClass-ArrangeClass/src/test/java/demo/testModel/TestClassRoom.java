package demo.testModel;

import com.hzs.service.IClassroomService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author hezhensheng
 * @version 1.0
 * @description TestClassRoom
 * @date 2019/6/6 22:12
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring.xml")
public class TestClassRoom {

    @Autowired
    private IClassroomService classroomService;

    @Test
    public void test1(){
        classroomService.findAllAscByCap()
                .stream()
                .forEach(classroom -> System.out.println(classroom));
    }

}
