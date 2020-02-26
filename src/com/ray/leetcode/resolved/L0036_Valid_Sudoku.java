package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Valid Sudoku
 *
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 * 	Each row must contain the digits 1-9 without repetition.
 * 	Each column must contain the digits 1-9 without repetition.
 * 	Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * A partially filled sudoku which is valid.
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 *
 * Example:
 *      Example 1
 *      Input:
 *      [
 *        [5,3,.,.,7,.,.,.,.],
 *        [6,.,.,1,9,5,.,.,.],
 *        [.,9,8,.,.,.,.,6,.],
 *        [8,.,.,.,6,.,.,.,3],
 *        [4,.,.,8,.,3,.,.,1],
 *        [7,.,.,.,2,.,.,.,6],
 *        [.,6,.,.,.,.,2,8,.],
 *        [.,.,.,4,1,9,.,.,5],
 *        [.,.,.,.,8,.,.,7,9]
 *      ]
 *      Output: true
 *      Example 2
 *      Input:
 *      [
 *        [8,3,.,.,7,.,.,.,.],
 *        [6,.,.,1,9,5,.,.,.],
 *        [.,9,8,.,.,.,.,6,.],
 *        [8,.,.,.,6,.,.,.,3],
 *        [4,.,.,8,.,3,.,.,1],
 *        [7,.,.,.,2,.,.,.,6],
 *        [.,6,.,.,.,.,2,8,.],
 *        [.,.,.,4,1,9,.,.,5],
 *        [.,.,.,.,8,.,.,7,9]
 *      ]
 *      Output: false
 *      Explanation: Same as Example 1, except with the 5 in the top left corner being 
 *          modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 *      Note:
 *      	A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 *      	Only the filled cells need to be validated according to the mentioned rules.
 *      	The given board contain only digits 1-9 and the character '.'.
 *      	The given board size is always 9x9.
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/valid-sudoku/
 * @since   2020-02-26 19:19:16
 */
public class L0036_Valid_Sudoku {

    /**
     * 验证每个行、列不能有重复数字以及小九宫格不能有重复数字
     *
     * 两种解法的核心差异在于，验证某个区域的数字是否有重复数字时，自然的两种算法
     *      1. 用每个数字和其余的数字比较，时间复杂度 O(n^2)
     *      2. 用hash统计已经存在的数字，时间复杂度 O(n)
     */
    static class Solution {
        public boolean isValidSudoku(char[][] board) {
            int[] count;

            // 验证每一列
            for (int row = 0; row < 9; row++) {
                count = new int[9];
                for (int col = 0; col < 9; col++) {
                    char c = board[row][col];
                    if (c == '.') continue;
                    count[c-'1'] ++;
                    if (count[c-'1'] > 1) return false;
                }
            }

            // 验证每一行
            for (int col = 0; col < 9; col++) {
                count = new int[9];
                for (int row = 0; row < 9; row++) {
                    char c = board[row][col];
                    if (c == '.') continue;
                    count[c-'1'] ++;
                    if (count[c-'1'] > 1) return false;
                }
            }

            // 验证每个九宫格
            for (int i = 0; i < 9; i += 3) {
                for (int j = 0; j < 9; j+=3) {
                    count = new int[9];
                    for (int k = 0; k < 9; k++) {
                        int x = i / 3 * 3 + k / 3, y = j / 3 * 3 + k % 3;
                        char c = board[x][y];
                        if (c == '.') continue;
                        count[c-'1'] ++;
                        if (count[c-'1'] > 1) return false;
                    }
                }
            }
            return true;
        }
    }

    class Solution2 {
        public boolean isValidSudoku(char[][] board) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] == '.') continue;
                    for (int k = 0; k < 9; k ++) {
                        if (k != j && board[i][j] == board[i][k]) return false;
                        if (k != i && board[i][j] == board[k][j]) return false;
                        int x = i / 3 * 3 + k / 3, y = j / 3 * 3 + k % 3;
                        if (x != i && y != j && board[i][j] == board[x][y]) return false;
                    }
                }
            }
            return true;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
