package demo.testService;

import com.hzs.model.Classroom;
import com.hzs.service.IClassroomService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author hezhensheng
 * @version 1.0
 * @description 教室的service测试
 * @date 2019/6/1 20:12
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring.xml")
public class TestClassroom {

    @Autowired
    private IClassroomService classroomService;

    @Test
    public void test1(){
        //查询所有
//        classroomService.findAll()
//                .forEach(classroom -> System.out.println(classroom));
        //增加一个教室
//        Classroom classroom=new Classroom(7,"计算机403",150);
//        classroomService.save(classroom);

        //更新一个教室
        Classroom classroom=classroomService.find(3);
        classroom.setName("计算机303");
        classroomService.update(classroom);
    }

}
