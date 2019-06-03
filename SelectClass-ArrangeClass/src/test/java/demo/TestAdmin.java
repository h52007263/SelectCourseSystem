package demo;

import com.hzs.action.AdminAction;
import com.hzs.action.base.BaseAction;
import com.hzs.dao.base.IBaseDao;
import com.hzs.model.Admin;
import com.hzs.model.PageBean;
import com.hzs.service.IAdminService;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author hzs
 * @description 管理员的测试类
 * @date 2019/5/24 10:45
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring.xml")
public class TestAdmin {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private IAdminService adminService;

    @Test
    public void testVagueQuery(){
//        String name="珍胜";
//        List<Admin> admins = adminService.vagueQuery(name);
//        admins.forEach(admin-> System.out.println(admin));

        String name="2";
        List<Admin> admins = adminService.vagueQuery1(name,"username");
        admins.forEach(admin-> System.out.println(admin));

    }

    @Test
    public void test2(){
        List<Admin> admins=adminService.findAll();
        admins.stream()
                .forEach(admin -> System.out.println(admin));
    }

    @Test
    public void testSave(){
        Admin admin=new Admin("hzs","123");
        admin.setId(1);
        adminService.save(admin);
    }

    @Test
    public void testDao(){
        PageBean<Admin> pb=new PageBean<>();
        pb.setCurr(0);
        pb.setLimit(3);
        adminService.pageQuery(pb);
        for(Admin a:pb.getData())
            System.out.println(a);
    }

    @Test
    public void testAction(){
        AdminAction adminAction=new AdminAction();
        adminAction.test();
    }
}
