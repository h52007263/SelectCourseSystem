package demo.testModel;

import com.hzs.model.ArrangeResult;
import com.hzs.model.ArrangeRule;
import com.hzs.service.IArrangeResultService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hezhensheng
 * @version 1.0
 * @description TestArrangeResult
 * @date 2019/6/6 20:17
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring.xml")
public class TestArrangeResult {

    @Autowired
    private IArrangeResultService arrangeResultService;

    @Test
    public void test3(){
        arrangeResultService.batchDelete("软件工程","2016");
    }

    @Test
    public void test1(){
//        System.out.println("生成表");

        ArrangeResult arrangeResult=new ArrangeResult("数据结构","2","软件303","软件工程",2016,"杨老师");
        ArrangeResult arrangeResult1=new ArrangeResult("计算机网络","3","软件203","软件工程",2016,"杨老师");
        List<ArrangeResult> arrangeResults=new ArrayList<>();
        arrangeResults.add(arrangeResult);
        arrangeResults.add(arrangeResult1);

        //(String courseName, String useTime, String roomName, String major, int grade, String teacherName
        arrangeResultService.batchSave(arrangeResults);

    }

    @Test
    public void test2(){

        Map<Integer,String> map=new HashMap<>();
        map.put(7,"没有课程");
        map.put(8,"没有课程");
        map.put(11,"没有课程");

        String major="软件工程";
        String grade="2016";

        List<ArrangeResult> arrangeResults = arrangeResultService.generateResult(map,major,grade);

        arrangeResults.stream()
                .forEach(arrangeResult -> System.out.println(arrangeResult));
    }
}
