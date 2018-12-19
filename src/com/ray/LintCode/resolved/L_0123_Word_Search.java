package com.ray.LintCode.resolved;

import com.ray.io.Out;
import com.ray.util.Timer;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * 给定一个字符组成二维格子，检查单词在面板中是否存在。字符可以和任意的上下左右字符相连。
 *
 * @author rays1
 *
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