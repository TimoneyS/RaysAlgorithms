package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.*;

/**
 * Word Search II
 * -----------------------------------------------------------------------------
 * Given a 2D board and a list of words from the dictionary, find all words in the board.
 * Each word must be constructed from letters of sequentially adjacent cell, where adjacent cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 *
 * Example:
 *      Example 1
 *      Input: 
 *      board = [
 *        ['o','a','a','n'],
 *        ['e','t','a','e'],
 *        ['i','h','k','r'],
 *        ['i','f','l','v']
 *      ]
 *      words = [oath,pea,eat,rain]
 *      Output: [eat,oath]
 *      Note:
 *      	All inputs are consist of lowercase letters a-z.
 *      	The values of words are distinct.
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/word-search-ii/
 * @since   2020-03-09 00:37:51
 */
public class L0212_Word_Search_II {
    static  class Solution {

        class Node {
            String val;
            HashMap<Character, Node> adj = new HashMap<>();
        }

        class Trie {
            Node root;
            public Trie(Node TrieNode) {
                root = TrieNode;
            }
            public void insert(String word) {
                Node node = root;
                Node prev = root;
                for (int i = 0; i < word.length(); i++) {
                    node = prev.adj.get(word.charAt(i));
                    if (node == null) prev.adj.put(word.charAt(i), node = new Node());
                    prev = node;
                }
                node.val = word;
            }
        }

        void search(char[][] board, int x, int y, Node root, Set<String> results) {

            if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) return;

            char key = board[x][y];
            Node child = root.adj.get(board[x][y]);

            if (child == null) return;
            if (child.val != null) results.add(child.val);

            board[x][y] = '-';  // mark board[x][y] as used

            search(board, x+1, y, child, results);
            search(board, x-1, y, child, results);
            search(board, x, y+1, child, results);
            search(board, x, y-1, child, results);

            board[x][y] = key;  // revert the mark
        }

        public List<String> findWords(char[][] board, String[] words) {
            Set<String> results = new HashSet<>();

            Trie tree = new Trie(new Node());
            for (String word : words) tree.insert(word);

            for (int i = 0; i < board.length; i++)
                for (int j = 0; j < board[i].length; j++)
                    search(board, i, j, tree.root, results);

            return new ArrayList<>(results);
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
