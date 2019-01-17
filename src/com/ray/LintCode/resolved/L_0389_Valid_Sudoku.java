package com.ray.LintCode.resolved;

/**
 * 验证数独
 * 数独面板可能是部分填充的，空的格子填充的字符为 "."
 * @author rays1
 *
 */
public class L_0389_Valid_Sudoku {

    /**
     * 验证每个行、列不能有重复数字以及小九宫格不能有重复数字
     * @author rays1
     *
     */
    static class Solution {
    
        public boolean isValidSudoku(char[][] board) {
            
            int[] count = new int[10];
            
            // 验证每一列
            for (int row = 0; row < 9; row++) {
                count = new int[10];
                for (int col = 0; col < 9; col++) {
                    char c = board[row][col]; 
                    if (c == '.') continue;
                    count[c-48] ++;
                    if (count[c-48] > 1) return false;
                }
            }
            
            // 验证每一行
            for (int col = 0; col < 9; col++) {
                count = new int[10];
                for (int row = 0; row < 9; row++) {
                    char c = board[row][col]; 
                    if (c == '.') continue;
                    count[c-48] ++;
                    if (count[c-48] > 1) return false;
                }
            }
            
            // 验证每个九宫格
            int[][] start = { {1,1}, {4,1}, {7,1} };
            int[][] dds = {
                    {-1, -1}, {-1, 0}, {-1, 1},
                    { 0, -1}, { 0, 0}, { 0, 1},
                    { 1, -1}, { 1, 0}, { 1, 1}
            };
            for (int i = 0; i <= 6; i += 3 ) {
                for (int[] cen : start) {
                    int row = cen[0], col = cen[1] + i;
                    for (int[] dd : dds) {
                        char c = board[row + dd[0]][col + dd[1]];
                        if (c == '.') continue;
                        count[c-48] ++;
                        if (count[c-48] > 1) return false;
                    }
                }
            }
            
            return true;
        }
    
    }
    
}
 