package com.ray.LintCode.resolved;

/**
 * 验证数独
 * 数独面板可能是部分填充的，空的格子填充的字符为 "."
 * @author rays1
 * @url    https://www.lintcode.com/problem/valid-sudoku/description
 * @date   2019-01-17 22:55:50
 */
public class L_0389_Valid_Sudoku {

    /**
     * 验证每个行、列不能有重复数字以及小九宫格不能有重复数字
     * 
     * 两种解法的核心差异在于，验证某个区域的数字是否有重复数字时，自然的两种算法
     *      1. 用每个数字和其余的数字比较，时间复杂度 O(n^2)
     *      2. 用hash统计已经存在的数字，时间复杂度 O(n)
     * @author rays1
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
    
    /**
     * 复杂度 9 * 9 * 9 * 3 的解法
     * 
     * @author rays1
     *
     */
    static class Solution2 {
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
    
}
 