package demo.testModel;

import com.hzs.dao.ICourseWishDao;
import com.hzs.model.CourseWish;
import com.hzs.service.ICourseWishService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.Column;
import java.util.List;

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

    @Autowired
    private ICourseWishDao courseWishDao;

    @Test
    public void test6(){
        CourseWish courseWish=new CourseWish();
        courseWish.setCourseId(16);
        courseWishService.delete(courseWish);
    }

    @Test
    public void test5(){
        List<CourseWish> list = courseWishService.vagueQueryByMajor("计算机","2016");

        list.stream()
                .forEach(courseWish -> System.out.println(courseWish));

    }

    @Test
    public void test4(){
        CourseWish courseWish=courseWishService.findByField("测试课程","courseName");
        courseWish.setWeight(0);
        courseWish.setSection(0);
        courseWish.setJoins(0);
        courseWish.setAmpm(0);
        courseWishService.updatePure(courseWish);
    }

    @Test
    public void test3(){
//        CourseWish courseWish=new CourseWish();
//        courseWish.setCourseId(10);
//        courseWish.setAmpm(34);
//        courseWish.setJoins(1);
//
//        courseWishService.update(courseWish);

        CourseWish courseWish=courseWishService.findByField("测试课程","courseName");
        courseWish.setWeight(0);
        courseWish.setSection(0);
        courseWish.setJoins(0);
        courseWish.setAmpm(0);
        courseWishService.updatePure(courseWish);
    }


    @Test
    public void test2(){
        String major="计算机";
        String grade="2016";
        List<CourseWish> courseWishList = courseWishDao.vagueQueryByMajor(major,grade);
        courseWishList.forEach(courseWish -> System.out.println(courseWish));
    }

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
