package com.test;

import org.apache.lucene.analysis.TokenStream;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;

/**
 * @author hzs
 * @description 理解分词器的原理
 * @date 2019/5/28 9:31
 */
public class IKAnalyzerDemo {
    public static void main(String[] args) throws IOException {
        /**
         * analyzer通过fieldName创建一个component
         * component获取一个tokenStream，分词器
         */
        IKAnalyzer analyzer = new IKAnalyzer();
        TokenStream ts=analyzer.tokenStream("username","帽子和服装");
        ts.reset();
        while(ts.incrementToken()){
            System.out.println(ts.reflectAsString(false));
        }
    }
}
