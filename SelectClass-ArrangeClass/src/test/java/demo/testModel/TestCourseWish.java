package demo.testModel;

import com.hzs.model.CourseWish;
import com.hzs.service.ICourseWishService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.Column;

/**
 * @author hezhensheng
 * @version 1.0
 * @description TestCourseWish
 * @date 2019/6/5 18:10
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring.xml")
public class TestCourseWish {

    @Autowired
    private ICourseWishService courseWishService;

    @Test
    public void test1(){
//        System.out.println("生成编排");

    //2.
        //(Integer courseId, String courseName, Integer weight, Integer section, Integer joins, Integer ampm)
        //courseWishService.save(new CourseWish(1,"数据结构",3,2,1,12));
        CourseWish courseWish =new CourseWish(2,"数据结构",3,2,1,12);
//        courseWishService.save(courseWish);
//        courseWish.setAmpm(34);
//        courseWishService.update(courseWish);
//        courseWishService.delete(courseWish);

        System.out.println(courseWishService.findByMaxId());


    }


}
