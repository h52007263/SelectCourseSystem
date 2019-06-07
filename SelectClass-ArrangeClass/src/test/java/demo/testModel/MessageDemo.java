package demo.testModel;

import com.hzs.model.Message;
import com.hzs.service.IMessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * @author hezhensheng
 * @version 1.0
 * @description 消息实体类的数据库操作测试
 * @date 2019/6/4 14:47
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring.xml")
public class MessageDemo {

    @Autowired
    private IMessageService messageService;

    @Test
    public void test1(){

        messageService.findAll().stream()
                .forEach(message -> System.out.println(message));

        //增加一条消息
//        Message message=new Message("计算机网络","计算机网络也很重要",new Date());
//
//        messageService.save(message);

    }
}
