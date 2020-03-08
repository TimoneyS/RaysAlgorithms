package com.ray.leetcode.resolved;

import java.util.HashMap;
import java.util.Map;

/**
 * Implement Trie (Prefix Tree)
 * -----------------------------------------------------------------------------
 * Implement a trie with insert, search, and startsWith methods.
 *
 * Example:
 *      Example 1
 *      Trie trie = new Trie();
 *      trie.insert(apple);
 *      trie.search(apple);   // returns true
 *      trie.search(app);     // returns false
 *      trie.startsWith(app); // returns true
 *      trie.insert(app);   
 *      trie.search(app);     // returns true
 *      Note:
 *      	You may assume that all inputs are consist of lowercase letters a-z.
 *      	All inputs are guaranteed to be non-empty strings.
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/implement-trie-prefix-tree/
 * @since   2020-03-09 00:14:22
 */
public class L0208_Implement_Trie_Prefix_Tree {
    /**
     * 使用 map 实现，空间复杂度教低，时间复杂度相对较高
     */
    static class Trie {

        Node root;

        class Node {
            String value;
            Map<Character, Node> adj;
            public Node() {
                adj = new HashMap<>();
            }
        }

        /** Initialize your data structure here. */
        public Trie() {
            root = new Node();
        }
        /** Inserts a word into the trie. */
        public void insert(String word) {
            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                char key = word.charAt(i);
                if (!node.adj.containsKey(key)) {
                    Node ch = new Node();
                    node.adj.put(key, ch);
                }
                node = node.adj.get(key);
            }
            node.value = word;
        }
        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                char key = word.charAt(i);
                if (node.adj.containsKey(key)) node = node.adj.get(key);
                else return false;
            }
            return node.value != null;
        }
        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            Node node = root;
            for (int i = 0; i < prefix.length(); i++) {
                char key = prefix.charAt(i);
                if (node.adj.containsKey(key)) node = node.adj.get(key);
                else return false;
            }
            return true;
        }
    }

    public static void main(String[] args) {
    }
}
