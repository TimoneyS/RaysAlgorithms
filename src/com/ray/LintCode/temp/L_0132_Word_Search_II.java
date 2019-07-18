package com.ray.LintCode.temp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a matrix of lower alphabets and a dictionary. Find all words in the dictionary that can be found in the matrix. A word can start from any position in the matrix and go left/right/up/down to the adjacent position. One character only be used once in one word. No same word in dictionary
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input：["doaf","agai","dcan"]，["dog","dad","dgdg","can","again"]
 *      Output：["again","can","dad","dog"]
 *      Explanation：
 *        d o a f
 *        a g a i
 *        d c a n
 *      search in Matrix，so return ["again","can","dad","dog"].
 *      ```
 *      
 *      **Example 2:**
 *      ```
 *      Input：["a"]，["b"]
 *      Output：[]
 *      Explanation：
 *       a
 *      search in Matrix，return [].
 *      ```
 *
 * 挑战：
 *      <p>Using trie to implement your algorithm.</p>
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/word-search-ii/description
 * @date   2019-07-11 18:30:58
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
