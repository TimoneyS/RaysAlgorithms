package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Game of Life
 * -----------------------------------------------------------------------------
 * According to the Wikipedia's article: The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970.
 * Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
 * 	Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 * 	Any live cell with two or three live neighbors lives on to the next generation.
 * 	Any live cell with more than three live neighbors dies, as if by over-population..
 * 	Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * Write a function to compute the next state (after one update) of the board given its current state. The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously.
 *
 * Example:
 *      Example 1
 *      Input: 
 *      [
 *        [0,1,0],
 *        [0,0,1],
 *        [1,1,1],
 *        [0,0,0]
 *      ]
 *      Output: 
 *      [
 *        [0,0,0],
 *        [1,0,1],
 *        [0,1,1],
 *        [0,1,0]
 *      ]
 *      Follow up:
 *      	Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
 *      	In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/game-of-life/
 * @since   2020-03-10 02:10:37
 */
public class L0289_Game_of_Life {
    /**
     * 1 表示活， 0 表示 死，
     * 那么临时用
     *      2 -> 死到活
     *      3 -> 活到死
     * 等到所有的细胞标记后，再处理标记的细胞
     */
    static class Solution {
        int[][] DIR = {
                {0, 1},
                {1, 0},
                {0, -1},
                {-1, 0},
                {1, 1},
                {1, -1},
                {-1, -1},
                {-1, 1}
        };

        public void gameOfLife(int[][] board) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    int c = count(board, i, j);
                    if (c == 3) {
                        if (board[i][j] == 0) board[i][j] += 2;
                    }
                    if (c != 3 && c != 2){
                        if (board[i][j] == 1) board[i][j] += 2;
                    }
                }
            }
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == 2) board[i][j] = 1;
                    if (board[i][j] == 3) board[i][j] = 0;
                }
            }
        }

        private int count(int[][] board, int i, int j) {
            int c = 0;
            for (int[] dir :DIR) {
                int x = dir[0] + i;
                int y = dir[1] + j;
                if (x >= 0 && y >= 0 && x < board.length && y < board[0].length) {
                    if ( board[x][y] == 1 ||  board[x][y] == 3)
                        c ++;
                }
            }
            return c;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
