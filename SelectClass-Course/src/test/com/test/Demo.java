package com.test;

import com.hzs.api.AdminApi;

/**
 * @author hzs
 * @description 测试
 * @date 2019/5/28 14:07
 */
public class Demo {
    public static void main(String[] args) {

        AdminApi adminApi=new AdminApi();
        adminApi.findAll().stream()
                .forEach(admin -> System.out.println(admin));

    }
}
