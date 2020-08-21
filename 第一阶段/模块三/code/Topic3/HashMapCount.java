package com.homework.Stage1.Section3.Topic3;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapCount {

    /**
     * 准备一个 HashMap 集合，统计字符串"123,456,789,123,456"中每个数字字符串出现的次数并打印出来。
     * 如：
     * 123 出现了 2 次
     * 456 出现了 2 次
     * 789 出现了 1 次
     * <p>
     * 解题思路：
     * 1、首先将题目中字符串拆分
     * 2、创建HashMap，循环拆分后字符串并插入至Map，Key为字符串，Value为出现次数
     * 3、因为Map特性，Key不能重复，所以插入前判断字符串是否已在Key集中，若存在，count+1，若不存在，直接插入，value = count = 1
     * 4、打印结果
     */

    public static final String str = "123,456,789,123,456";

    public static void main(String[] args) {

        HashMap<String, Integer> map = new HashMap<>();
//        拆分字符串
        String[] sp = str.split(",");

//        遍历判断插入
        for (String s : sp) {
            Integer integer = map.get(s);
            int count = 1;
//            判断Key中是否已经有待插入的字符串，若存在，value = count + 1，若不存在，直接插入，value = count = 1
            if (integer != null) {
                count += 1;
                map.put(s, count);
            } else {
                map.put(s, count);
            }
        }

//        遍历map并打印
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + "出现了" + entry.getValue() + "次。");
        }
    }
}


