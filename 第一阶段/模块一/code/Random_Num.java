package com.homework.Stage1.Section1;

import java.util.Arrays;
import java.util.Random;

public class Random_Num {

//    实现双色球抽奖游戏
//    中奖号码的生成，中奖号码由 6 个红球号码和 1 个蓝球号码组成。
//    其中红球号码要求随机生成 6 个 1~33 之间不重复的随机号码。
//    其中蓝球号码要求随机生成 1 个 1~16 之间的随机号码。


    public static void main(String[] args) {

        Random rm = new Random();
        int[] serial = new int[7];
        serial[6] = rm.nextInt(15) + 1;
        boolean[] bool = new boolean[32];
        int random_index = 0;
        for (int i = 0; i < serial.length - 1; i++) {
            do {
                random_index = rm.nextInt(32) + 1;
            } while (bool[random_index]);
            bool[random_index] = true;
            serial[i] = random_index;
        }
        System.out.println(Arrays.toString(serial));
    }
}
