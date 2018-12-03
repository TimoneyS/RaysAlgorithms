package com.ray.LintCode.resolved;

import java.util.ArrayList;
import java.util.List;

import com.ray.util.Timer;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard
 * such that no two queens attack each other.
 * 
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * 
 * Each solution contains a distinct board configuration of the n-queens' placement,
 * where 'Q' and '.' both indicate a queen and an empty space respectively.
 * 
 * <p>
 * Example
 * <p>
 * There exist two distinct solutions to the 4-queens puzzle:<br>
 * <li> [
 * <li>   // Solution 1
 * <li>   [".Q..",
 * <li>    "...Q",
 * <li>    "Q...",
 * <li>    "..Q."
 * <li>   ],
 * <li>   // Solution 2
 * <li>   ["..Q.",
 * <li>    "Q...",
 * <li>    "...Q",
 * <li>    ".Q.."
 * <li>   ]
 * <li> ]
 * <li> 
 * <p>
 * Challenge : no recursion
 * @author rays1
 *
 */
public class L_0033_N_Queens {
    static class Solution {
        
        int N;
        
        /*
         * @param n: The number of queens
         * @return: All distinct solutions
         */
        public List<List<String>> solveNQueens(int n) {
            N = n;
            List<List<String>> rs = new ArrayList<List<String>>();
            boolean[][] marked = new boolean[n][n];
            solveNQueens(rs, 0, marked);
            return rs;
        }

        private void solveNQueens(List<List<String>> rs, int row, boolean[][] marked) {
            for (int col = 0; col < N; col++) {
                if (hasQueue(row, col, marked)) continue;
                marked[row][col] = true;
                if (row == N-1) solveResult(rs, marked);
                else            solveNQueens(rs, row+1, marked);
                marked[row][col] = false;
            }
            
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
        
        private void solveResult(List<List<String>> rs, boolean[][] marked) {
            List<String> list = new ArrayList<String>(N);
            for (boolean[] rows : marked) {
                StringBuilder sb = new StringBuilder();
                for (boolean isQueue : rows) {
                    sb.append( isQueue ? 'Q':'.');
                }
                list.add(sb.toString());
            }
            rs.add(list);
        }
        
    }
    
    static class Solution_No_Recursion {
        
        /*
         * @param n: The number of queens
         * @return: All distinct solutions
         */
        public List<List<String>> solveNQueens(int n) {
            
            List<List<String>> rs = new ArrayList<List<String>>();
            int[] stack = new int[n];
            
            boolean[][] marked = new boolean[n][n];
            
            int row = 0, col = 0;
            while (true) {
                
                if (hasQueue(marked, n, row, col)) {
                    col ++;
                } else {
                    marked[row][col] = true;
                    if (row == n-1) {
                        solveResult(rs, marked);
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
        
        private void solveResult(List<List<String>> rs, boolean[][] marked) {
            List<String> list = new ArrayList<String>(marked.length);
            for (boolean[] rows : marked) {
                StringBuilder sb = new StringBuilder();
                for (boolean isQueue : rows) {
                    sb.append( isQueue ? 'Q':'.');
                }
                list.add(sb.toString());
            }
            rs.add(list);
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
        
        int n = 13;
        
        Timer.CLICK();
        new Solution_No_Recursion().solveNQueens(n);
        Timer.CLICK();
        new Solution().solveNQueens(n);
        Timer.STOP();
        
    }
    
}
