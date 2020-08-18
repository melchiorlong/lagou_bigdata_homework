package com.homework.Stage1.Section1;

import java.util.Scanner;

public class Day_In_Year_Calculate {

//    提示用户输入年月日信息，判断这一天是这一年中的第几天并打印。

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入年");
        int year = sc.nextInt();
        System.out.println("请输入月");
        int month = sc.nextInt();
        System.out.println("请输入日");
        int day = sc.nextInt();
        int day_sum = calculate(year, month, day);
        System.out.println("这是这一年中第" + day_sum + "天。");
    }

    //  判断是否闰年
    public static boolean is_leap(int year) {

        boolean isLeap = true;
        if (year % 100 == 0) {
            isLeap = year % 400 == 0 ? true : false;
        } else {
            isLeap = year % 4 == 0 ? true : false;
        }
        return isLeap;
    }

    //  计算合计日(除2月外)
    public static int calculate(int year, int month, int days) {
//  每月几天
//  31天     ---1、3、5、7、8、10、12
//  30天     ---4、6、9、11
//  28or29天 ---2
        boolean isLeap = is_leap(year);
        int days_31 = 31;
        int days_30 = 30;
        int days_28 = 28;
        int days_29 = 29;
        int day_sum = 0;
        switch (month) {
            case 12:
                day_sum += days_30;
            case 11:
                day_sum += days_31;
            case 10:
                day_sum += days_30;
            case 9:
                day_sum += days_31;
            case 8:
                day_sum += days_31;
            case 7:
                day_sum += days_30;
            case 6:
                day_sum += days_31;
            case 5:
                day_sum += days_30;
            case 4:
                day_sum += days_31;
            case 3:
                if (isLeap) {
                    day_sum += days_29;
                } else {
                    day_sum += days_28;
                }
            case 2:
                day_sum += days_31;
            case 1:
                day_sum += days;
        }

        return day_sum;
    }
}
