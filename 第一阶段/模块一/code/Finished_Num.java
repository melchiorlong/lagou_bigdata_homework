package com.homework.Stage1.Section1;

import static java.lang.Math.sqrt;

public class Finished_Num {

//    编程找出1000以内的所有完数并打印出来。
//    所谓完数就是一个数恰好等于它的因子之和 如 6=1 2 3

    public static void main(String[] args) {

        for (int i = 1; i < 1000; i++) {
            int sum_temp = 0;
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    sum_temp += j;
                }
            }
            if (i == sum_temp) {
                System.out.println(i + "是完数");
            }
        }
    }
}

