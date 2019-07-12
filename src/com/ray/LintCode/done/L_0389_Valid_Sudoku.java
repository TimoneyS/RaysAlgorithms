package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      Determine whether a Sudoku is valid.
 *      
 *      The Sudoku board could be partially filled, where empty cells are filled with the character `.`.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```plain
 *      Input:
 *      ["53..7....","6..195...",".98....6.","8...6...3","4..8.3..1","7...2...6",".6....28.","...419..5","....8..79"]
 *      Output: true
 *      Explanation: 
 *      The sudoku is look like this. It's vaild.
 *      ```
 *      
 *      ![Valid Sudoku](https://lintcode-media.s3.amazonaws.com/problem/valid-sudoku.png "Valid Sudoku")
 *      
 *      **Example 2:**
 *      
 *      ```Input
 *      Input:
 *      ["53..7j...","6..195...",".98....6.","8...6...3","4..8.3..1","7...2...6",".6....28.","...419..5","....8..79"]
 *      Output: false
 *      Explanation: 
 *      The sudoku is look like this. It's invaild because there are two '5' in the first row and the sixth line.
 *      ```
 *      
 *      ![image](https://ws3.sinaimg.cn/large/6a8de5f4ly1g0s5st12otj206y06yaa5.jpg)
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/valid-sudoku/description
 * @date   2019-07-11 18:32:26
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
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
