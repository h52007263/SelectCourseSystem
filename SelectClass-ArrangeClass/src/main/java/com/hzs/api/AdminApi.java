package com.hzs.api;

import com.hzs.model.Admin;
import com.hzs.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import java.io.Serializable;

/**
 * @author hzs
 * @description 接口
 * @date 2019/5/26 20:22
 */

@ContextConfiguration(locations = "classpath:spring/spring.xml")
public class AdminApi extends BaseApi<Admin>{

    public AdminApi(){
        context=new ClassPathXmlApplicationContext(new String[] { "spring/spring.xml" });
        baseService= (IAdminService) context.getBean("adminServiceImpl");
    }

    public static void main(String[] args) {
        AdminApi adminApi=new AdminApi();
//        System.out.println(adminApi.findById(2));

        Admin admin1=new Admin("用户名","密码");
        adminApi.save(admin1);

    }

}
