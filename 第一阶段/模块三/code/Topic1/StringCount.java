package com.homework.Stage1.Section3.Topic1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCount {

    /**
     * 编程统计字符串"ABCD123!@#$%ab"中大写字母、小写字母、数字、其它字符的个数并打 印出来。
     * <p>
     * 解题思路：
     * 通过正则表达式找出要求中的写字母、小写字母、数字、其它字符的
     * 得到新字符串的长度后打印
     */


    private static final String STR = "ABCD123!@#$%ab";

    public static void main(String[] args) {

        System.out.println("原始字符串是：" + STR);
        System.out.println();

//        寻找大写字母
        String upper_pattern = "[A-Z]+";
        Pattern p1 = Pattern.compile(upper_pattern);
        Matcher m1 = p1.matcher(STR);
        if (m1.find()) {
            System.out.println("大写字母：" + m1.group());
            System.out.println("个数为：" + m1.group().length() + "个");
        } else {
            System.out.println("not find");
        }

        System.out.println("----------------------------------------");

//        寻找小写字母
        String lower_pattern = "[a-z]+";
        Pattern p2 = Pattern.compile(lower_pattern);
        Matcher m2 = p2.matcher(STR);
        if (m2.find()) {
            System.out.println("小写字母：" + m2.group());
            System.out.println("个数为：" + m2.group().length() + "个");
        } else {
            System.out.println("not find");
        }

        System.out.println("----------------------------------------");

//        寻找数字
        String num_pattern = "[0-9]+";
        Pattern p3 = Pattern.compile(num_pattern);
        Matcher m3 = p3.matcher(STR);
        if (m3.find()) {
            System.out.println("数字为：" + m3.group());
            System.out.println("个数为：" + m3.group().length() + "个");
        } else {
            System.out.println("not find");
        }

        System.out.println("----------------------------------------");

//        寻找其他字符
        String non_pattern = "[\\W]+";
        Pattern p4 = Pattern.compile(non_pattern);
        Matcher m4 = p4.matcher(STR);
        if (m4.find()) {
            System.out.println("特殊字符为：" + m4.group());
            System.out.println("个数为：" + m4.group().length() + "个");
        } else {
            System.out.println("not find");
        }
    }
}
