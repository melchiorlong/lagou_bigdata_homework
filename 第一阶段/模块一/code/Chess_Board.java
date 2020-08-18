package com.homework.Stage1.Section1;

public class Chess_Board {

//    使用双重循环实现五子棋游戏棋盘的绘制棋盘界面

    private String[][] chess_board;
    private String[] str = new String[]{"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};
    private final int size = str.length;

    public void setChess_board() {
        chess_board = new String[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                chess_board[i][j] = "+";
            }
        }
    }

        private void print(){
            System.out.print(" ");
            for (int i = 0; i < size; i++) {
                System.out.print("  " + str[i]);
            }
            System.out.println();
            for (int i = 0; i < size; i++) {
                System.out.print(str[i] + "  ");
                for (int j = 0; j < size; j++) {
                    System.out.print(chess_board[i][j] + "  ");
                }
                System.out.println();
            }
        }

    public static void main(String[] args) {
        Chess_Board chessboard = new Chess_Board();
        chessboard.setChess_board();
        chessboard.print();
    }
}
