package com.ray.LintCode.resolved;

import java.util.ArrayDeque;
import java.util.Queue;

import com.ray.io.Out;

/**
 * 2D的面板上包含 X 和 O两种字符，抓取所有的被 X 包围的区域
 *
 *
 *Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O''s into 'X''s in that surrounded region.
 *
 * @author rays1
 *
 */
public class L_0477_Surrounded_Regions {

    /**
     * 从边缘的 O开始图的搜索，标记搜索到的O
     * 
     * 然后将所有未标记的 O 转换为 X
     * 
     * 复杂度，O(n^2)
     * 
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public void surroundedRegions(char[][] board) {
            if (board == null) return ;
            int m = board.length;
            if (m == 0) return;
            int n = board[0].length;
            if (n == 0) return;
            
            Queue<Integer> queue = new ArrayDeque<>();
            
            for (int i = 0; i < m; i ++) {
                if (board[i][0] == 'O') {
                    board[i][0] = 'Z';
                    queue.add(i*n);
                }
                if (board[i][n-1] == 'O') {
                    board[i][n-1] = 'Z';
                    queue.add(i*n + n-1);
                }                
            }
            
            
            for (int j = 1; j < n-1; j ++) {
                if (board[0][j] == 'O') {
                    board[0][j] = 'Z';
                    queue.add(j);
                }
                if (board[m-1][j] == 'O') {
                    board[m-1][j] = 'Z';
                    queue.add((m-1)*n + j);
                }
            }
            
            
            int[][] dirs = {
                    { 1,  0},
                    {-1,  0},
                    { 0,  1},
                    { 0, -1}
            };
            while (!queue.isEmpty()) {
                int idx = queue.poll();
                int i = idx / n;
                int j = idx % n;
                for (int[] dir : dirs) {
                    int ti = i + dir[0]; 
                    int tj = j + dir[1];
                    if ( ti >= 0 && ti < m && tj >=0 && tj < n && board[ti][tj] == 'O') {
                        board[ti][tj] = 'Z';
                        queue.add(ti*n+tj);
                    }
                }
            }
            
            for (int i = 0; i < m; i ++) {
                for (int j = 0; j < n; j++) {
                    switch(board[i][j]) {
                        case 'O' : board[i][j] = 'X';break;
                        case 'Z' : board[i][j] = 'O';break;
                    }
                }
            }
            
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
