package com.homework.Stage1.Section2.Topic1;

import java.util.Arrays;
import java.util.Random;

/**
 * 1. 编程实现以下需求：
 * 定义一个长度为[16][16]的整型二维数组
 * 输入或指定所有位置的元素值
 * 分别实现二维数组中所有行和所有列中所有元素的累加并打印。
 * 分别实现二维数组中左上角到右下角和右上角到左下角所有元素的累加和并打印。
 * <p>
 * 解题思路
 * 1、按照题目要求创建二维数组
 * 2、随机给数组中元素一个值
 * 3、垂直方向和垂直方向求和并打印，固定行（列）累加求和即可
 * 4、斜向求和
 * 左上 -> 右下 所有元素下标相等，即int[0][0] + int[1][1] + .....
 * 双重循环后int[j][j] 累加即可
 * 右上 -> 左下 所有元素下标相加等于length - 1,即int[0][15] + int[1][14] + ....
 * 双重循环后int[i][length - 1 - i] 累加即可
 *
 * 备注:
 * 注释的代码也可实现累加，但是代码没有上述方法简洁
 * 故使用上述代码
 */
public class TwoDimensionArray {

    // 定义一个长度为[16][16]的整型二维数组
    private final int[][] chess_board = new int[16][16];

    // 输入或指定所有位置的元素值
    public void inserting() {
        for (int i = 0; i < chess_board.length; i++) {
            for (int j = 0; j < chess_board[0].length; j++) {
                int r2 = new Random().nextInt(10);
                chess_board[i][j] = r2;
            }
        }
    }

    // 分别实现二维数组中所有行和所有列中所有元素的累加并打印
    public void sumVerticalHorizon() {

        int[] vertical = new int[16];
        for (int i = 0; i < chess_board.length; i++) {
            int sumHorizon = 0;
            int[] horizon = chess_board[i];
            sumHorizon = Arrays.stream(horizon).sum();
            System.out.println("第" + (i + 1) + "行数字合计值 = " + sumHorizon);
            for (int j = 0; j < chess_board.length; j++) {
                vertical[j] = chess_board[j][i];
            }
            int sumVertical = Arrays.stream(vertical).sum();
            System.out.println("第" + (i + 1) + "列数字合计值 = " + sumVertical);
        }

//        for (int i = 0; i < chess_board.length; i++) {
//            int sumHorizon = 0;
//            int[] horizon = chess_board[i];
//            sumHorizon = Arrays.stream(horizon).sum();
//            System.out.println("第" + (i + 1) + "行数字合计值 = " + sumHorizon);
//        }
//        System.out.println("------------------------------");
//        for (int i = 0; i < chess_board.length; i++) {
//            for (int j = 0; j < chess_board.length; j++) {
//                vertical[j] = chess_board[j][i];
//            }
//            int sumVertical = Arrays.stream(vertical).sum();
//            System.out.println("第" + (i + 1) + "列数字合计值 = " + sumVertical);
//        }
//        System.out.println("------------------------------------------------------------");
    }

    // 分别实现二维数组中左上角到右下角和右上角到左下角所有元素的累加和并打印
    public void sumDiagonal() {
        int[] diagonal2left = new int[16];
        int[] diagonal2right = new int[16];
        for (int i = 0; i < chess_board.length; i++) {
            for (int j = 0; j < chess_board.length; j++) {
                diagonal2right[j] = chess_board[j][j];
                diagonal2left[i] = chess_board[i][chess_board.length - 1 - i];
            }
        }
        System.out.println("左上角到右下角的合计值为" + Arrays.stream(diagonal2right).sum());
        System.out.println("右上角到左下角的合计值为" + Arrays.stream(diagonal2left).sum());
    }

    public void show() {
        for (int i = 0; i < chess_board.length; i++) {
            for (int j = 0; j < chess_board[i].length; j++) {
                System.out.print(chess_board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        TwoDimensionArray tda = new TwoDimensionArray();
        tda.inserting();
        tda.show();
        tda.sumVerticalHorizon();
        tda.sumDiagonal();
    }
}
