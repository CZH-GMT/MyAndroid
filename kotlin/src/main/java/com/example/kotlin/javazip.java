package com.example.kotlin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//TODO kotlin zip合并集合 Java实现
public class javazip {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<String>();
        list1.add("李四");
        list1.add("王五");
        list1.add("张三");

        ArrayList<Integer> list2 = new ArrayList();
        list2.add(1);
        list2.add(2);
        list2.add(3);

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < list1.size(); i++) {
             map.put(list1.get(i), list2.get(i));
        }

        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
            System.out.println("你的名字是"+stringIntegerEntry.getKey()+"你的年龄是"+stringIntegerEntry.getValue());
        }

    }

}
