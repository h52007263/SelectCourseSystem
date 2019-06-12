package demo;

import com.hzs.model.User;
import com.hzs.service.IUserService;
import net.sf.json.JSONObject;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hzs
 * @description 测试数据库连接
 * @date 2019/5/23 13:32
 */
@SpringJUnitConfig
@ContextConfiguration(locations = { "classpath:spring/spring.xml" })
public class TestConn {
    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Autowired
    private IUserService userService;

    @Test
    public void testUpdate(){
        System.out.println("更新了");
    }

    //测试更新
    @Test
    public void test5(){
        String hql="UPDATE User set name=?0,age=?1,sex=?2 where id=?3";
        User user=new User("hzs1",12,"男");
        user.setId(1);
        userService.updateUser(hql,user);
    }

    @Test
    public void test4(){
        List<User> users = userService.getUserByPage(0,3);
        users.stream()
                .forEach(user -> System.out.println(user));
    }

    @Test
    public void test3(){
        Map<String,Object> map = new HashMap<>();
        List<User> users = userService.getUserByAll();
        map.put("code",0);
        map.put("msg","");
        map.put("ok",true);
        map.put("count",users.size());
        map.put("data",users);

        JSONObject jsonObject=JSONObject.fromObject(map);
        System.out.println(jsonObject);
    }

    @Test
    public void test2(){
        User user=new User("hzs",18,"男");
        userService.addUser(user);
    }

    @Test
    public void test1(){
        System.out.println("初始化数据库的表");
        System.out.println(sessionFactory);
        System.out.println(hibernateTemplate);
//        Student student = (Student) sessionFactory.getCurrentSession().
//                createQuery("from Student where id = ?").setParameter(0, stuId).uniqueResult();
//        System.out.println(student);
    }
}
