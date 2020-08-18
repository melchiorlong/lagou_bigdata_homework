package com.homework.Stage1.Section2.Topic2;

public class ChessBoardCons {

    private final int length = 16;
    private String[][] chess_board;
    private final String[] str = new String[length];
    private final int size = str.length;

    public ChessBoardCons() {
    }

    public String[][] getChess_board() {
        return chess_board;
    }

    public void setChess_board(String[][] chess_board) {
        this.chess_board = chess_board;
    }

    public void generating(){
        insert();
        setChess_board();
        print();
    }

    public void rePrint(String[][] chess_board){
        insert();
        print();
    }

    private void insert(){
        for (int i = 0; i < size; i++) {
            str[i] = Integer.toHexString(i);
        }
    }

    private void setChess_board() {
        // 初始化棋盘中心二维数组
        chess_board = new String[size][size];
        // 用“+”填充
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                chess_board[i][j] = "+";
            }
        }
    }

    private void print(){
        // 打印图中左上角空格
        System.out.print(" ");
        // 循环打印坐标数组作为行坐标
        for (int i = 0; i < size; i++) {
            System.out.print("  " + str[i]);
        }
        // 换行
        System.out.println();

        // 双重for循环打印其余部分
        for (int i = 0; i < size; i++) {
            // 打印坐标数组作为列坐标
            System.out.print(str[i] + "  ");
            for (int j = 0; j < size; j++) {
                // 打印棋盘中心“+”
                System.out.print(chess_board[i][j] + "  ");
            }
            // 换行
            System.out.println();
        }
    }
}
