package com.utils;

import com.model.Product;
import org.apache.commons.io.FileUtils;
import org.hibernate.criterion.Projection;

import java.util.ArrayList;
import java.util.List;
import java.io.*;

/**
 * @author hzs
 * @description txt文件转为泛型为Product集合的工具类
 * @date 2019/5/28 10:04
 */
public class ProductUtil {
    public static void main(String[] args) throws IOException {
//        String fileName="E:\\download\\jar\\lib_lucene\\source\\140k_products\\140k_products.txt";
//        List<Product> products=file2list(fileName);
//        System.out.println(products.size());

        String s="10001";
        int i=Integer.parseInt(s);
        System.out.println(i);

    }

    public static List<Product> file2list(String fileName) throws IOException {
        File f=new File(fileName);
        List<String> lines = FileUtils.readLines(f,"UTF-8");
        List<Product> products=new ArrayList<>();
        for(String line : lines){
            Product p=line2Product(line);
            products.add(p);
        }
        return products;
    }

    private static Product line2Product(String line){
        Product p=new Product();
        String[] fields=line.split(",");

        p.setId(Integer.parseInt(fields[0]));
        p.setName(fields[1]);
        p.setCategory(fields[2]);
        p.setPrice(Float.parseFloat(fields[3]));
        p.setPlace(fields[4]);
        p.setCode(fields[5]);
        return p;
    }

}
