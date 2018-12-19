package com.ray.LintCode.resolved;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ray.io.Out;

/**
 *
 * 给定一个字符组成二维格子，和一个字典。字符可以和任意的上下左右字符相连，检查字典中的单词在面板中是否存在。
 * 
 * Example
 * 
 * matrix:
 *    doaf
 *    agai
 *    dcan
 * 
 * dictionary: {"dog", "dad", "dgdg", "can", "again"}
 * 
 * return :    {"dog", "dad", "can", "again"}
 * 
 * @author rays1
 *
 */
public class L_0132_Word_Search_II {

    static class Solution {
        
        class Node {
            String val;
            HashMap<Character, Node> adj;
            public Node() {
                val = null;
                adj = new HashMap<Character, Node>();
            }
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
                    if (node == null) {
                        prev.adj.put(word.charAt(i), node = new Node());
                    }
                    prev = node;
                }
                node.val = word;
            }
        }
        
        public void search(char[][] board, int x, int y, Node root, Set<String> results) {
            
            if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
                return;
            }            
            
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
        
        public List<String> wordSearchII(char[][] board, List<String> words) {
            Set<String> results = new HashSet<String>();
            
            Trie tree = new Trie(new Node());
            for (String word : words){
                tree.insert(word);
            }
            
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    search(board, i, j, tree.root, results);
                }
            }

            return new ArrayList<>(results);        
        }
    }
    
    public static void main(String[] args) {
        
        String[] dict = {"dog", "dad", "dgdg", "can", "again"};
        List<String> words = Arrays.asList(dict);
        
        char[][] board = {
                { 'd','o','a','f'},
                { 'a','g','a','i'},
                { 'd','c','a','n'}
        };
        
        
        Out.p(new Solution().wordSearchII(board, words));
        
    }

}
