package com.ray.LintCode.resolved;

import java.util.HashSet;
import java.util.Set;

import com.ray.io.Out;

/**
 *Write a program to solve a Sudoku puzzle by filling the empty cells.

Empty cells are indicated by the number 0.

You may assume that there will be only one unique solution.
 * @author rays1
 *
 */
public class L_0802_Sudoku_Solver {

    /**
     * DFS
     * @author rays1
     *
     */
    static class Solution {
    
        int n, m;
        int[][] board;
        
        public void solveSudoku(int[][] board) {
            if (board == null || board.length == 0) return;
            n = board.length;
            m = board[0].length;
            if (n != 9 || m != 9) return;
            this.board = board;
//            Out.p(avliable(0,0));
            helper(0, 0, 1);
        }
        
        private boolean helper(int i, int j, int level) {
            if (i > 8) return true;
            int ni = j == 8 ? i+1:i;
            int nj = j == 8 ? 0:j+1;
            
            if (board[i][j] != 0) return helper(ni, nj, level + 1);
            
            Set<Integer> set = avliable(i, j);
            if (set.size() == 0) return false;
            for (int n : set) {
                board[i][j] = n;
                if (helper(ni, nj, level + 1))
                    return true;
                board[i][j] = 0;
            }
            return false;
                
        }

        public Set<Integer> avliable(int i, int j) {
            Set<Integer> set = new HashSet<>();
            for (int n = 1; n <= 9; n++) set.add(n);
            for (int k = 0; k < 9; k++) {
                set.remove(board[k][j]);
                set.remove(board[i][k]);
            }
            
            int rstat = stat(i), cstat = stat(j);// 判断ij所属的小九宫格

            for (int k = 0;k < 3; k++) {
                for (int l = 0; l < 3; l++) {
                    set.remove(board[rstat+l][cstat+k]);
                }
            }
            
            return set;
        }
        
        int stat(int i) {
            return i / 3 * 3;
        }
    
    }
    
    public static void main(String[] args) {
        
        int[][] board = {
                {0,0,9,7,4,8,0,0,0},
                {7,0,0,0,0,0,0,0,0},
                {0,2,0,1,0,9,0,0,0},
                {0,0,7,0,0,0,2,4,0},
                {0,6,4,0,1,0,5,9,0},
                {0,9,8,0,0,0,3,0,0},
                {0,0,0,8,0,3,0,2,0},
                {0,0,0,0,0,0,0,0,6},
                {0,0,0,2,7,5,9,0,0}};
        
        new Solution().solveSudoku(board);
        
        Out.p(board, "%s ");
        
    }

}
