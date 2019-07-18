package com.ray.LintCode.temp;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述：
 *      Design a data structure that supports the following two operations: `addWord(word)` and `search(word)`
 *      
 *      `search(word)` can search a literal word or a regular expression string containing only letters `a-z` or `.`.
 *      
 *      A `.` means it can represent any one letter.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input:
 *        addWord("a")
 *        search(".")
 *      Output:
 *        true
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input:
 *        addWord("bad")
 *        addWord("dad")
 *        addWord("mad")
 *        search("pad")  
 *        search("bad")  
 *        search(".ad")  
 *        search("b..")  
 *      Output:
 *        false
 *        true
 *        true
 *        true
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/add-and-search-word-data-structure-design/description
 * @date   2019-07-11 18:33:24
 */
public class L_0473_Add_and_Search_Word___Data_structure_design {

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
        
        
    }

}
