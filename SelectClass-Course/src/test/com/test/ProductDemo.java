package com.test;

import java.io.*;

/**
 * @author hzs
 * @description 导入测试文件
 * @date 2019/5/28 9:44
 */
public class ProductDemo {
    public static void main(String[] args) {
        File f=new File("E:\\download\\jar\\lib_lucene\\source\\140k_products\\140k_products.txt");
        System.out.println(f.length()/1024+" KB");
    }
}
