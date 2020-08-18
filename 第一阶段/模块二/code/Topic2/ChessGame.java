package com.homework.Stage1.Section2.Topic2;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 2. 编程实现控制台版并支持两人对战的五子棋游戏。
 * （1）绘制棋盘 - 写一个成员方法实现
 * （2）提示黑方和白方分别下棋并重新绘制棋盘 - 写一个成员方法实现。
 * （3）每当一方下棋后判断是否获胜 - 写一个成员方法实现。
 * （4）提示： 采用二维数组来模拟并描述棋盘，棋盘如下：
 *
 * 解题思路:
 * 根据五子棋的规则，任意方向上（水平垂直斜向 五个同颜色棋子连起来即胜利，且不区分顺序）细分为有方向性的8个方向
 * 复用模块1的棋盘作业生成棋盘
 * 根据输入的棋子位置更新二位数组中的元素，需要判断是否越界，是否已经被占用
 * 只有3种结局，1、白胜利 2、黑胜利 3、平局即和棋
 * 因棋盘为16*16=256个棋子位置，如果棋盘上棋子数量为256个时且没有分出胜负，即判定为平局
 * 若有任意一方胜利，即结束循环，宣布该方胜利
 * 其中判断胜负的方法：
 * 每下一个棋子，需要判断该棋子周围8个方向有无5个同颜色棋子
 * 即：
 * 垂直方向：1、上->下    2、下->上
 * 水平方向：3、左->右    4、右->左
 * 斜   向：5、左上->右下 6、左下->右上
 * 斜   向：7、右上->左下 8、右下->左上
 *
 * 最后根据循环判断所得的结果输出即可
 */
public class ChessGame {

    private boolean isFinished = false;
    private int stepCount = 0;
    private int winner = 0;
    private int whichOne = 1;
    private final int length = 16;
    private final String[] str = new String[length];
    private final int size = str.length;
    private final String[] edge = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
    private final static char WHITE = '\u25CB'; // WHITE = ○
    private final static char BLACK = '\u25CF'; // BLACK = ●


    public void start(String[][] chess_board) {

        List<String> edge_list = Arrays.asList(edge);
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println(whichOne > 0 ? "白方下棋，请出入横纵坐标（如：1 2）" : "黑方下棋，请出入横纵坐标（如：1 2）");
            String inx = sc.next();
            String iny = sc.next();
//            判断输入坐标是否越界
            if (!edge_list.contains(inx) || !edge_list.contains(iny)) {
                System.out.println("位置越界，请重新下棋");
                continue;
            }
            int x = (int) Long.parseLong(inx, 16);
            int y = (int) Long.parseLong(iny, 16);
//            判断输入坐标是否已经被使用
            if (!chess_board[x][y].equals("+")) {
                System.out.println("位置已经被使用，请重新下棋");
                continue;
            }
//          更新数组
            update(x, y, whichOne, chess_board);
//          交换对手
            whichOne *= -1;
//            打印棋盘
            insert();
            print(chess_board);

//          循环每个数组中的位置，判断是否结束及谁是胜者
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    if (!isFinished) {
                        winner = whoIsWinner(chess_board, i, j);
                    }
                }
            }
            stepCount += 1;
        } while (!isFinished || stepCount == 256);
        {
            System.out.println("游戏结束");
            if (stepCount == 256) {
                System.out.println("平局");
            } else {
                if (winner > 0) {
                    System.out.println("黑方胜利");
                } else {
                    System.out.println("白方胜利");
                }
            }
        }
    }

    /**
     * 更新棋盘，根据输入坐标更新二维数组元素值为white或black
     *
     * @param x 横坐标
     * @param y 纵坐标
     */
    public void update(int x, int y, int whichOne, String[][] chess_board) {
        if (whichOne > 0) {
            chess_board[x][y] = String.valueOf(WHITE);
        } else {
            chess_board[x][y] = String.valueOf(BLACK);
        }
    }

    /**
     * 判断胜负
     * @return 返回值 1：黑胜 -1：白胜
     */
    public int whoIsWinner(String[][] chess_board, int x, int y) {
//        当前位置
        int piecesCount = 0;
//        初始化结果int
        int result = 1;
//        初始化一个boolean
        boolean flag = false;
//        声明当前位置棋子
        String currentPieces = chess_board[x][y];

        // 如果当前位置是"+"则直接跳出
        if (!currentPieces.equals("+")) {
            // 水平垂直判断
            // 左 - 右
            for (int i = y; i < length; i++) {
                if (chess_board[x][i].equals(currentPieces)) {
                    piecesCount++;
                } else {
                    break;
                }
            }
            if (piecesCount >= 5) {
                flag = true;
            } else {
                piecesCount = 0;
            }
            // 右 - 左
            for (int i = y; i >= 0; i--) {
                if (chess_board[x][i].equals(currentPieces)) {
                    piecesCount++;
                } else {
                    break;
                }
            }
            if (piecesCount >= 5) {
                flag = true;
            } else {
                piecesCount = 0;
            }
            // 上 - 下
            for (int i = x; i < length; i++) {
                if (chess_board[i][y].equals(currentPieces)) {
                    piecesCount++;
                } else {
                    break;
                }
            }
            if (piecesCount >= 5) {
                flag = true;
            } else {
                piecesCount = 0;
            }
            // 下 - 上
            for (int i = x; i >= 0; i--) {
                if (chess_board[i][y].equals(currentPieces)) {
                    piecesCount++;
                } else {
                    break;
                }
            }
            if (piecesCount >= 5) {
                flag = true;
            } else {
                piecesCount = 0;
            }


            // 斜向
            // 左上 - 右下
            for (int i = x, j = y; i < length && j < length; i++, j++) {
                if (chess_board[i][j].equals(currentPieces)) {
                    piecesCount++;
                } else {
                    break;
                }

            }
            if (piecesCount >= 5) {
                flag = true;
            } else {
                piecesCount = 0;
            }
            // 右下 - 左上
            for (int i = x, j = y; i >= 0 && j >= 0; i--, j--) {
                if (chess_board[i][j].equals(currentPieces)) {
                    piecesCount++;
                } else {
                    break;
                }
            }
            if (piecesCount >= 5) {
                flag = true;
            } else {
                piecesCount = 0;
            }
            // 左下 - 右上
            for (int i = x, j = y; i < length && j >= 0; i++, j--) {
                if (chess_board[i][j].equals(currentPieces)) {
                    piecesCount++;
                } else {
                    break;
                }
            }
            if (piecesCount >= 5) {
                flag = true;
            } else {
                piecesCount = 0;
            }
            // 右下 - 左上
            for (int i = x, j = y; i >= 0 && j < length; i--, j++) {
                if (chess_board[i][j].equals(currentPieces)) {
                    piecesCount++;
                } else {
                    break;

                }
            }
            if (piecesCount >= 5) {
                flag = true;
            }

            if (flag) {
                isFinished = true;
                result = currentPieces.equals(String.valueOf(WHITE)) ? -1 : 1;
                return result;
            }
        }
        return result;
    }

    private void insert() {
        for (int i = 0; i < size; i++) {
            str[i] = Integer.toHexString(i);
        }
    }

    private void print(String[][] chess_board) {
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

    public static void main(String[] args) {
        // 绘制棋盘
        ChessGame cg = new ChessGame();
        ChessBoardCons cbc = new ChessBoardCons();
        cbc.generating();
        String[][] chess_board = cbc.getChess_board();
        // 提示黑方和白方分别下棋、重新绘制棋盘
        cg.start(chess_board);
    }
}
