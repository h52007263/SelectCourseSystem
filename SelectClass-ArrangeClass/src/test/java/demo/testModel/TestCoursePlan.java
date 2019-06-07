package demo.testModel;

import com.hzs.dao.ICoursePlanDao;
import com.hzs.model.Course;
import com.hzs.service.ICoursePlanService;
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

}
