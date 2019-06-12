package demo.testModel;

import com.hzs.dao.IArrangeRuleDao;
import com.hzs.model.ArrangeResult;
import com.hzs.model.ArrangeRule;
import com.hzs.service.IArrangeRuleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.Serializable;
import java.util.List;

/**
 * @author hezhensheng
 * @version 1.0
 * @description 排课规则的测试类
 * @date 2019/6/3 18:50
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring.xml")
public class ArrangeRuleTest {

    @Autowired
    private IArrangeRuleDao arrangeRuleDao;

    @Autowired
    private IArrangeRuleService arrangeRuleService;

    @Test
    public void test1(){
//        arrangeRuleDao.findAll()
//                .stream().forEach(arrangeRule -> System.out.println(arrangeRule));

//        arrangeRuleService.findAll()
//                .forEach(arrangeRule -> System.out.println(arrangeRule));


    }

    @Test
    public void test2(){
        System.out.println("初始化表");
    }

}
