package com.ray.leetcode.resolved;

import java.util.HashMap;
import java.util.Map;

/**
 * Add and Search Word - Data structure design
 * -----------------------------------------------------------------------------
 * Design a data structure that supports the following two operations:
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
 *
 * Example:
 *      Example 1
 *      addWord(bad)
 *      addWord(dad)
 *      addWord(mad)
 *      search(pad) -> false
 *      search(bad) -> true
 *      search(.ad) -> true
 *      search(b..) -> true
 *      Note:
 *      You may assume that all words are consist of lowercase letters a-z.
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/add-and-search-word-data-structure-design/
 * @since   2020-03-09 00:33:57
 */
public class L0211_Add_and_Search_Word_Data_structure_design {
    /**
     * 使用 trie 和递归的实现，效率教低
     * 效率高的方法，以后再想
     */
    static class WordDictionary {

        class Node {
            String value;
            Map<Character, Node> adj = new HashMap<>();
        }

        Node root = new Node();

        /** Initialize your data structure here. */
        public WordDictionary() {
        }
        /** Adds a word into the data structure. */
        public void addWord(String word) {
            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                char key = word.charAt(i);
                if (!node.adj.containsKey(key))
                    node.adj.put(key, new Node());
                node = node.adj.get(key);
            }
            node.value = word;
        }
        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            return search(root, word, 0);
        }

        boolean search(Node node, String word, int start) {
            if (start == word.length()) return node.value != null;
            char key = word.charAt(start);
            if (key == '.') {
                for (java.util.Map.Entry<Character, Node> entry : node.adj.entrySet()) {
                    if (search(entry.getValue(), word, start+1))
                        return true;
                }
            } else {
                if (!node.adj.containsKey(key)) {
                    return false;
                } else {
                    return search(node.adj.get(key), word, start+1);
                }
            }
            return false;
        }
    }
    
    public static void main(String[] args) {
    }
}
