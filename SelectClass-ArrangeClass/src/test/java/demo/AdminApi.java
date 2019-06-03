package demo;

import com.hzs.model.Admin;
import com.hzs.service.IAdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.Serializable;

/**
 * @author hzs
 * @description 提供给其他模块的接口
 * @date 2019/5/26 20:09
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring.xml")
public class AdminApi {
    @Autowired
    private IAdminService adminService;

    @Test
    public void test1(){
        System.out.println(adminService);
    }

}
