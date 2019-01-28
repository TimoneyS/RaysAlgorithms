package com.ray.LintCode.resolved;

import java.util.HashMap;
import java.util.Map;

import com.ray.io.Out;

/**
 *
 * 设计一个数据结构，这种结构支持两种操作：
 *      1. addWord(word)
 *      2. search(word)
 *          支持搜索单词或者正则表达式，正则表达式包含 a-z 或者 ., . 表示任意的单个字符
 * @author rays1
 *
 */
public class L_0473_Add_and_Search_Word_Data_structure_design {

    /**
     * 使用 trie 和递归的实现，效率教低
     * 效率搞的方法，以后再想
     * @author rays1
     *
     */
    static class WordDictionary {
        
        class Node {
            String value;
            Map<Character, Node> adj = new HashMap<>();
        }
        
        Node root = new Node();
        
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

        public boolean search(String word) {
            return search(root, word, 0);
        }
        
        public boolean search(Node node, String word, int start) {
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
        
        WordDictionary dict = new WordDictionary();
        
        dict.addWord("abc");
        dict.addWord("ab");
        
        Out.p(dict.search("a.."));
        
    }

}
