package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      参考 L_0033_N_Queens
 *      N 皇后问题
 *      替代输出棋盘，直接输出所有可能的解的数量。
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/n-queens-ii/description
 * @date   2019-07-11 17:36:50
 */
public class L_0034_N_Queens_II {

    static class Solution {
        
        int N;
        
        /**
         * @param n: The number of queens.
         * @return: The total number of distinct solutions.
         */
        public int totalNQueens(int n) {
            N = n;
            boolean[][] marked = new boolean[n][n];
            return totalNQueens(0, 0, marked);
        }

        private int totalNQueens(int rs, int row, boolean[][] marked) {
            for (int col = 0; col < N; col++) {
                if (hasQueue(row, col, marked)) continue;
                marked[row][col] = true;
                if (row == N-1) {
                    rs ++;
                } else {
                    rs = totalNQueens(rs, row+1, marked);
                }
                marked[row][col] = false;
            }
            return rs;
        }
        
        private boolean hasQueue(int row, int col, boolean[][] marked) {
            int colL,colR;
            for (int i = 1; i <= row; i++) {
                colL = col-i;
                colR = col+i;
                if ( (marked[row-i][col]) ||
                        (colL >= 0 && colL < N && marked[row-i][colL]) ||
                        (colR >= 0 && colR < N && marked[row-i][colR])) {
                    return true;
                }
            }
            return false;
        }
        
    }
    
    static class Solution_No_Recursion {
        
        /**
         * @param n: The number of queens.
         * @return: The total number of distinct solutions.
         */
        public int totalNQueens(int n) {
            
            int rs = 0;
            int[] stack = new int[n];
            boolean[][] marked = new boolean[n][n];
            
            int row = 0, col = 0;
            while (true) {
                
                if (hasQueue(marked, n, row, col)) {
                    col ++;
                } else {
                    marked[row][col] = true;
                    if (row == n-1) {
                        rs ++;
                        marked[row][col] = false;
                        col = n;
                    } else {
                        stack[row] = col;
                        row ++;
                        col = 0;
                    }
                }
                
                // 回退
                while (col >= n) {
                    stack[row] = 0;
                    row --;
                    if (row < 0) return rs;
                    col = stack[row]+1;
                    marked[row][stack[row]] = false;
                }
                
            }
        }
        
        private boolean hasQueue(boolean[][] marked, int N, int row, int col) {
            int colL,colR;
            for (int i = 1; i <= row; i++) {
                colL = col-i;
                colR = col+i;
                if ( (marked[row-i][col]) ||
                        (colL >= 0 && colL < N && marked[row-i][colL]) ||
                        (colR >= 0 && colR < N && marked[row-i][colR])) {
                    return true;
                }
            }
            return false;
        }
        
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
