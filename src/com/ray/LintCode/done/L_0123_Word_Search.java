package com.ray.LintCode.done;

import com.ray.io.Out;
import com.ray.util.Timer;

/**
 * 描述：
 *      <p style="line-height: 30px;">Given a 2D board and a word, find if the word exists in the grid.</p><p style="line-height: 30px;">The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.</p>
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input：["ABCE","SFCS","ADEE"]，"ABCCED"
 *      Output：true
 *      Explanation：
 *      [    
 *           A B C E
 *           S F C S 
 *           A D E E
 *      ]
 *      (0,0)A->(0,1)B->(0,2)C->(1,2)C->(2,2)E->(2,1)D
 *      ```
 *      
 *      **Example 2:**
 *      ```
 *      Input：["z"]，"z"
 *      Output：true
 *      Explanation：
 *      [ z ]
 *      (0,0)z
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/word-search/description
 * @date   2019-07-11 18:30:52
 */
public class L_0123_Word_Search {

    static class Solution {
        
        public boolean exist(char[][] board, String word) {
            
            int[][] mem = new int[board.length+2][board[0].length+2];
            int max = 0;
            
            for (int l = 0; l < word.length(); l++) {
                
                for (int i = 0; i < board.length; i++) {
                    for (int j = 0; j < board[0].length; j++) {
                        if (word.charAt(l) == board[i][j]) {
                            if (mem[i+1][j] >= l || mem[i+1][j+2] >= l || mem[i][j+1] >= l || mem[i+2][j+1] >= l) {
                                mem[i+1][j+1] = 1 + l;
                                max = Math.max(max, mem[i+1][j+1]);
                            }
                        }
                    }
                    if (max < l) break;
                }
                
            }
            
            return max == word.length();
        }
        
    }
    
    static class Solution1 {
        
        public boolean exist(char[][] board, String word) {
            
            boolean rs = false;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (exist(board, i, j, word, word.length()-1)) {
                        rs = true;
                        break;
                    }
                }
                if (rs) break;
            }
            
            return rs;
        }
        
        public boolean exist(char[][] board, int i, int j, String word, int start) {
            
            if (start < 0) return true;
            if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) return false;
            if (board[i][j] != word.charAt(start)) return false;
            
            board[i][j] = '-';
            boolean rs = (
                    exist(board, i-1, j, word, start-1) ||
                    exist(board, i+1, j, word, start-1) ||
                    exist(board, i, j-1, word, start-1) ||
                    exist(board, i, j+1, word, start-1));
            board[i][j] = word.charAt(start);
            return rs;
        }
        
    }
    
    public static void main(String[] args) {
        
        String word = "ABCB";
        
        String[] boardString = {
                "ABCE","SFCS","ADEE"
        };
        
        int m = boardString.length;
        int n = boardString[0].length();
        
        char[][] board = new char[m][n];
        
        int i = 0;
        for (String string : boardString) {
            board[i++] = string.toCharArray();
        }
        
//        Timer.CLICK();
//        Out.p(new Solution().exist(board, word));
        Timer.CLICK();
        Out.p(new Solution().exist(board, word));
        Timer.STOP();
    }

}
