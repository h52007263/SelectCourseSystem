package demo.testModel;

import com.hzs.model.CourseWish;
import com.hzs.service.ICourseWishService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author hezhensheng
 * @version 1.0
 * @description CourseWish_Course
 * @date 2019/6/8 9:20
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring.xml")
public class CourseWish_Course {

    @Autowired
    private ICourseWishService courseWishService;

    @Test
    public void test1(){
        System.out.println("生成关联");
        CourseWish courseWish = courseWishService.find(1);

        System.out.println(courseWish);

        System.out.println(courseWish.getCourse());

    }

}
