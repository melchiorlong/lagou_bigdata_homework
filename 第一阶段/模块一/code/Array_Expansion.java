package com.homework.Stage1.Section1;

import java.util.Arrays;

public class Array_Expansion {

//    自定义数组扩容规则，当已存储元素数量达到总容量的80%时，扩容1.5倍。
//    例如，总容量是10 ，当输入第 8 个元素时，数组进行扩容，容量从 10 变 15 。

    public static void main(String[] args) {

        int[] num_ori = new int[10];
        for (int i = 0; i < 10; i++) {
            num_ori[i] = i;
        }
        array_expansion(num_ori);
    }

    public static void array_expansion(int[] num_ori) {

        int count = 0;
        for (int i : num_ori
        ) {
            if (i != 0) {
                count++;
            }
        }
        if (count % num_ori.length >= 8) {
            int[] arr_temp = new int[(int) (1.5 * num_ori.length)];
            System.arraycopy(num_ori, 0, arr_temp, 0, num_ori.length);
            num_ori = arr_temp;
        }
        System.out.println(Arrays.toString(num_ori));
    }
}