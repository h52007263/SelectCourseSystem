package com.hzs.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * @author hezhensheng
 * @version 1.0
 * @description 反射工具类
 * @date 2019/6/2 0:14
 */

/**
 *  方法：
 *      invokeMethod  获取属性的值
 *      getMethodName   属性的首字母大写
 *      这个工具类的作用：传入一个属性，考虑该属性是private所以将首字母大写，前面加上"get"，
 *      通过反射获取该属性的值。
 */
public class ReflexUtil {
        static Logger logger = LoggerFactory.getLogger(ReflexUtil.class);
        //getMethod
        static public Object invokeMethod(String propertiesName, Object object) {
        try {
            if (object == null) return null;
            if (!propertiesName.contains(".")) {
                //getId
                String methodName = "get" + getMethodName(propertiesName);
                Method method = object.getClass().getMethod(methodName);
                return method.invoke(object);
            }
                String methodName = "get" + getMethodName(propertiesName.substring(0, propertiesName.indexOf(".")));
                Method method = object.getClass().getMethod(methodName);
                return invokeMethod(propertiesName.substring(propertiesName.indexOf(".") + 1), method.invoke(object));
        } catch (Exception e) {
            logger.error(e.toString(), e);
        return null;
            }
        }

        //将属性的首字母变大写
        private static String getMethodName(String fieldName) {
            byte[] items = fieldName.getBytes();
            items[0] = (byte)((char) items[0] - 'a' + 'A');
            return new String(items);
        }

    public static void main(String[] args) {

    }

 }
