package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Word Search
 *
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/word-search/
 * @since   2020-02-29 22:52:07
 */
public class L0079_Word_Search {
    static class Solution {
        public boolean exist(char[][] board, String word) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (dfs(board, i, j, word, 0)) {
                        return true;
                    }
                }
            }
            return false;
        }

        public boolean dfs(char[][] board, int i, int j, String word, int cursor) {
            if (cursor == word.length()) {
                return true;
            }
            if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(cursor)) {
                return false;
            }
            board[i][j] = '-';
            boolean rs = dfs(board, i-1, j, word, cursor+1) ||
                            dfs(board, i+1, j, word, cursor+1) ||
                            dfs(board, i, j-1, word, cursor+1) ||
                            dfs(board, i, j+1, word, cursor+1);
            board[i][j] = word.charAt(cursor);
            return rs;
        }
    }

    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
