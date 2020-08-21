package com.homework.Stage1.Section3.Topic2;

import java.util.*;

public class MaxSameString {

    /**
     * 编程获取两个指定字符串中的最大相同子串。
     * <p>
     * 如： s1="asdafghjka", s2="aaasdfg" 他们的最大子串为"asd"
     * <p>
     * 提示： 将短的那个串进行长度依次递减的子串与较长的串比较。
     * <p>
     * 解题思路：
     * 1、判断两个字符串大小
     * 2、将小的字符串遍历取出所有子集并截取
     * 3、判断大字符串是否包含截取的字符串
     * 4、将包含的字符串存在List中
     * 5、从List中取出最长的元素
     */

    public static final String s1 = "asdafghjka";
    public static final String s2 = "aaasdfg";


    public static void main(String[] args) {

        String big_str = s1.length() - s2.length() >= 0 ? s1 : s2;
        String small_str = s1.length() - s2.length() >= 0 ? s2 : s1;
        List<String> subList = new ArrayList<>();
        List<String> result_temp = new ArrayList<>();
        List<String> result = new ArrayList<>();
        int max = 0;

//        遍历所有子字符串，并存入subList中
        for (int i = 0; i < small_str.length(); i++) {
            for (int j = i + 1; j <= small_str.length(); j++) {
                String substring = small_str.substring(i, j);
                subList.add(substring);
            }
        }

//        通过HashSet 将subList去重，提高性能
        HashSet<String> hashSet = new HashSet<>(subList);
        subList.clear();
        subList.addAll(hashSet);

//        循环判断长字符串包含哪些子串
        for (String s : subList) {
            if (big_str.contains(s)) {
                result_temp.add(s);
            }
        }

//        遍历出所包含字串中的最大长度
        for (String s : result_temp) {
            int length = s.length();
            if (length > max) {
                max = length;
            }
        }

//        将最大长度元素取出
        for (String s : result_temp) {
            if (s.length() == max) {
                result.add(s);
            }
        }

//      打印结果
        System.out.println("最大子串是：" + result);
    }
}
