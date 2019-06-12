package demo.testModel;

import com.hzs.dao.ICoursePlanDao;
import com.hzs.model.Course;
import com.hzs.model.CoursePlan;
import com.hzs.model.CourseWish;
import com.hzs.service.ICoursePlanService;
import com.hzs.service.ICourseWishService;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author hezhensheng
 * @version 1.0
 * @description TestCoursePlan
 * @date 2019/6/6 17:00
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring.xml")
public class TestCoursePlan {

    @Autowired
    private ICoursePlanService coursePlanService;

    @Autowired
    private ICoursePlanDao coursePlanDao;

    @Autowired
    private ICourseWishService courseWishService;

    @Test
    public void test1(){
        coursePlanService.vagueQueryByMajor("计算机","2016")
                .stream().forEach(coursePlan -> System.out.println(coursePlan));
    }

    @Test
    public void test2(){
        List<Course> list = coursePlanDao.findCourse();

        String[] strs=new String[]{"curr","limit","coursePlan","teacher","courseId"};
        JsonConfig config=new JsonConfig();
        config.setExcludes(strs);
        JSONArray jsonArray=JSONArray.fromObject(list,config);

        System.out.println(jsonArray.toString());
    }

    @Test
    public void test3(){
        coursePlanService.findCourse()
                .forEach(course -> System.out.println(course));
    }

    @Test
    public void test4(){
        CoursePlan coursePlan=coursePlanService.find(14);
//        CoursePlan coursePlan=new CoursePlan();
        coursePlan.setCourseplanId(14);
        coursePlanService.delete(coursePlan);
    }

    @Test
    public void testAddCascade(){
//        List<CoursePlan> coursePlans = coursePlanService.findAll();
//        coursePlans.forEach(
//                coursePlan -> System.out.println(coursePlan)
//        );

        CoursePlan coursePlan=new CoursePlan(2,1);
        String  courseName = "高等数学";
        String major="车辆工程";
        coursePlanService.save(coursePlan,major,courseName);



    }

    @Test
    public void test5(){
        CoursePlan coursePlan = coursePlanService.find(13);
        coursePlan.setSection(2);
        coursePlan.setWeight(2);
        coursePlanService.updateCascade(coursePlan);
    }

    @Test
    public void testVagueByName(){
//        List<CoursePlan> coursePlans = coursePlanService.vagueQuery1("计算机","");
//        coursePlans.forEach(
//                coursePlan -> System.out.println(coursePlan.getCourse())
//        );

        CoursePlan coursePlan=coursePlanService.find(23);
        int courseId = coursePlan.getCourse().getCourseId();
        coursePlanService.delete(coursePlan);
        CourseWish courseWish=new CourseWish();
        courseWish.setCourseId(courseId);
        courseWishService.delete(courseWish);

    }

}
