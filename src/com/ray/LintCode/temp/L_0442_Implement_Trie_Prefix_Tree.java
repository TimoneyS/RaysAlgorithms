package com.ray.LintCode.temp;

import java.util.HashMap;
import java.util.Map;

import com.ray.io.Out;

/**
 * 描述：
 *      Implement a Trie with `insert`, `search`, and `startsWith` methods.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input:
 *        insert("lintcode")
 *        search("lint")
 *        startsWith("lint")
 *      Output:
 *        false
 *        true
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input:
 *        insert("lintcode")
 *        search("code")
 *        startsWith("lint")
 *        startsWith("linterror")
 *        insert("linterror")
 *        search("lintcode)
 *        startsWith("linterror")
 *      Output:
 *        false
 *        true
 *        false
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
 * @url    https://www.lintcode.cn/problem/implement-trie-prefix-tree/description
 * @date   2019-07-11 18:33:10
 */
public class L_0442_Implement_Trie_Prefix_Tree {


    /**
     * 使用 map 实现，空间复杂度教低，时间复杂度相对较高
     * @author rays1
     *
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
        
        public Trie() {
            root = new Node();
        }

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

        public boolean search(String word) {
            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                char key = word.charAt(i);
                if (node.adj.containsKey(key)) node = node.adj.get(key);
                else return false;
            }
            return node.value != null;
        }

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
        
        Trie trie = new Trie();
        
        
        
        trie.insert("lintcode");
        Out.p(trie.search("code")); 
        Out.p(trie.startsWith("lint"));
        Out.p(trie.startsWith("linterror"));
        trie.insert("linterror");
        Out.p(trie.search("lintcode"));
        Out.p(trie.startsWith("linterror"));
        
        
    }

}
