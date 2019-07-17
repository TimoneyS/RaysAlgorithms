package com.ray.LintCode.done;

import java.util.ArrayList;
import java.util.List;

import com.ray.io.Out;

/**
 * 描述：
 *      N皇后谜题是在一个 n*n 的棋盘上放置 n 个皇后，同时这些皇后不会彼此攻击到对方。
 *      给定数字 n 返回所有可能的唯一解。
 *      每个解中 'Q' 表示 皇后位置，'.'表示空白位置
 *      
 * 用例：
 *      Example 2:
 *      输入:4
 *      输出:
 *      [
 *        [".Q..",
 *         "...Q",
 *         "Q...",
 *         "..Q."
 *        ],
 *        ["..Q.",
 *         "Q...",
 *         "...Q",
 *         ".Q.."
 *        ]
 *      ]
 *      
 *      ```
 *
 * 挑战：
 *      <p>Can you do it without recursion?</p>
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/n-queens/description
 * @date   2019-07-11 17:38:46
 */
public class L_0033_N_Queens {

    /**
     * 递归解法
     * 
     * N皇后问题的解法中，每一行，每一列都只会有一个皇后存在。
     * 因此第一个皇后在第一行，第二个皇后在第二行 。。。
     * 
     * 因此只要递归的求解每一行的皇后可以摆放的位置即可。
     * 
     * @author rays1
     *
     */
    static class Solution {
        
        int N;
        
        public List<List<String>> solveNQueens(int n) {
            N = n;
            List<List<String>> rs = new ArrayList<>();
            boolean[][] marked = new boolean[n][n];
            solveNQueens(rs, 0, marked);
            return rs;
        }

        private void solveNQueens(List<List<String>> rs, int row, boolean[][] marked) {
            
            for (int col = 0; col < N; col++) {
                if (hasQueue(row, col, marked)) {
                    continue;
                }
                marked[row][col] = true;
                if (row == N-1) {
                    solveResult(rs, marked);
                } else {
                    solveNQueens(rs, row+1, marked);
                }
                marked[row][col] = false;
            }
            
        }
        
        /**
         * 检测某个点所在的列、对角线上是否有其他的皇后
         */
        private boolean hasQueue(int row, int col, boolean[][] marked) {
            for (int i = 1; i <= row; i++) {
                if (    marked[row-i][col] ||
                        col-i >= 0 && col-i < N && marked[row-i][col-i] ||
                        col+i >= 0 && col+i < N && marked[row-i][col+i]) {
                    return true;
                }
            }
            return false;
        }
        
        private void solveResult(List<List<String>> rs, boolean[][] marked) {
            List<String> list = new ArrayList<>(N);
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
    
    /**
     * 非递归解法
     * 
     * 非递归解法就是显式的编写一个栈来存储每个阶段，替代递归过程的自动入栈出栈过程。
     * 
     * @author rays1
     *
     */
    static class Solution_No_Recursion {
        
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
            List<String> list = new ArrayList<>(marked.length);
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
            for (int i = 1; i <= row; i++) {
                if (    marked[row-i][col] ||
                        col-i >= 0 && col-i < N && marked[row-i][col-i] ||
                        col+i >= 0 && col+i < N && marked[row-i][col+i]) {
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
