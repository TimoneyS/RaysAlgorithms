package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * N-Queens II
 *
 * The n-queens puzzle is the problem of placing n queens on an n&times;n chessboard such that no two queens attack each other.
 * Given an integer n, return the number of distinct solutions to the n-queens puzzle.
 * Example:
 * Input: 4
 * Output: 2
 * Explanation: There are two distinct solutions to the 4-queens puzzle as shown below.
 * [
 *  [.Q..,  // Solution 1
 *   ...Q,
 *   Q...,
 *   ..Q.],
 *  [..Q.,  // Solution 2
 *   Q...,
 *   ...Q,
 *   .Q..]
 * ]
 *
 * Example:
 *      
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/n-queens-ii/
 * @since   2020-02-27 22:22:38
 */
public class L0052_N_Queens_II {
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
