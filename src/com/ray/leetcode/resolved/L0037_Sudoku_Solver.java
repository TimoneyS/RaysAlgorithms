package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.HashSet;
import java.util.Set;

/**
 * Sudoku Solver
 *
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * A sudoku solution must satisfy all of the following rules:
 * 	Each of the digits 1-9 must occur exactly once in each row.
 * 	Each of the digits 1-9 must occur exactly once in each column.
 * 	Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
 * Empty cells are indicated by the character '.'.
 * A sudoku puzzle...
 * ...and its solution numbers marked in red.
 * Note:
 * 	The given board contain only digits 1-9 and the character '.'.
 * 	You may assume that the given Sudoku puzzle will have a single unique solution.
 * 	The given board size is always 9x9.
 *
 * Example:
 *      
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/sudoku-solver/
 * @since   2020-02-26 19:26:29
 */
public class L0037_Sudoku_Solver {
    static class Solution {

        int n, m;
        char[][] board;

        public void solveSudoku(char[][] board) {
            if (board == null || board.length == 0) return;
            n = board.length;
            m = board[0].length;
            if (n != 9 || m != 9) return;
            this.board = board;
            for (int i = 0; i < board.length; i ++) {
                for (int j = 0; j < board.length; j++) {
                    if (board[i][j] == '.') {
                        board[i][j] = '0';
                    }
                }
            }
            helper(0, 0, 1);
        }

        private boolean helper(int i, int j, int level) {
            if (i > 8) return true;
            int ni = j == 8 ? i+1:i;
            int nj = j == 8 ? 0:j+1;

            if (board[i][j] != '0') return helper(ni, nj, level + 1);

            Set<Character> set = avliable(i, j);
            if (set.size() == 0) return false;
            for (char n : set) {
                board[i][j] = (char) (n);
                if (helper(ni, nj, level + 1))
                    return true;
                board[i][j] = '0';
            }
            return false;

        }

        public Set<Character> avliable(int i, int j) {
            Set<Character> set = new HashSet<>();
            for (int n = 1; n <= 9; n++) set.add((char) (n+'0'));
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
        Out.p(new Solution());
    }
}
