package com.hzs.util;

import com.hzs.util.model.SortModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author hezhensheng
 * @version 1.0
 * @description 比较器工具类
 * @date 2019/6/2 0:18
 */

public class CompareUtil {
 //sort 1正序 -1 倒序  filed 多字段排序
    //publiv static <t>
    public static Comparator createComparator(int sort, String... filed) {
        return new ImComparator(sort, filed);
    }

    public static class ImComparator implements Comparator {
        int sort = 1;
        String[] filed;

        public ImComparator(int sort, String... filed) {
            this.sort = sort == -1? -1: 1;
            this.filed = filed;
        }

        @Override
        public int compare(Object o1, Object o2) {
            int result = 0;
            for(String file : filed) {
                Object value1 = ReflexUtil.invokeMethod(file, o1);
                Object value2 = ReflexUtil.invokeMethod(file, o2);
                if(value1 == null|| value2 == null) {
                    continue;
                }
                if(!(value1 instanceof Integer) || !(value1 instanceof Integer)) {
                    continue;
                }
                int v1 = Integer.valueOf(value1.toString());
                int v2 = Integer.valueOf(value2.toString());
                if(v1 == v2) continue;
                if(sort == 1) {
                    return v1 - v2;
                }else if(sort == -1) {
                    return v2 - v1;
                }else{
                    continue;
                }
            }
            return result;
        }
}

    public static void main(String args[]) {
        SortModel model1=new SortModel(1,8,10);
        SortModel model2=new SortModel(3,10,10);
        SortModel model3=new SortModel(3,10,12);
        SortModel model4=new SortModel(1,10,9);
        SortModel model5=new SortModel(2,100,10);

        List<SortModel> list=new ArrayList<>();
        list.add(model1);
        list.add(model2);
        list.add(model3);
        list.add(model4);
        list.add(model5);

        Collections.sort(list,CompareUtil.createComparator(-1,"id","hp","price"));

        for(SortModel model:list)
            System.out.println(model);

    }

}
