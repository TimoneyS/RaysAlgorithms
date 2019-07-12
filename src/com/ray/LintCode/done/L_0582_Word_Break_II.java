package com.ray.LintCode.done;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
 *      
 *      Return all such possible sentences.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input："lintcode"，["de","ding","co","code","lint"]
 *      Output：["lint code", "lint co de"]
 *      Explanation：
 *      insert a space is "lint code"，insert two spaces is "lint co de".
 *      ```
 *      
 *      **Example 2:**
 *      ```
 *      Input："a"，[]
 *      Output：[]
 *      Explanation：dict is null.
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/word-break-ii/description
 * @date   2019-07-11 18:34:20
 */
public class L_0582_Word_Break_II {


    /**
     * 标准动态规划
     * 
     * 1. 先利用字典构建单词查找树
     * 
     * 2. 从左向右遍历字符串并同时开启查找
     *      如果在位置i查找命中，则说明可能在此处断句
     *      则递归从 i+1 开始查找子字符串的断句方式
     * 
     * 字符串的断句方式 = { 断句单词1 + 子字符串1断句方式 } + { 断句单词2 + 子字符串2断句方式 } ...
     * 需要注意一个点就是，到到达字符串末尾时，断句方式就是断句单词
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        class TrieNode {
            String  value;
            Map<Character, TrieNode> map = new HashMap<>();
            boolean contains(char key) {return map.containsKey(key);}
        }
        
        void addToTrie(TrieNode root, String s, int start) {
            if (start == s.length()) {
                root.value = s;
            } else {
                char key = s.charAt(start);
                if (!root.contains(key))  root.map.put(key, new TrieNode());
                addToTrie(root.map.get(key), s, start+1);
            }
        }
        
        TrieNode build(Set<String> wordDict) {
            TrieNode root = new TrieNode();
            for (String s : wordDict) addToTrie(root, s, 0);
            return root;
        }
        
        Map<Integer, List<String>> cache;
        
        public List<String> wordBreak(String s, Set<String> wordDict) {
            TrieNode root   = build(wordDict);
            cache           = new HashMap<>();
            
            return helper(s, 0, root);
        }
        
        List<String> helper(String s, int start, TrieNode root) {
            
            if (!cache.containsKey(start)) {
                List<String> rs = new ArrayList<>();
                TrieNode node = root;
                for (int i = start; i < s.length(); i++) {
                    char key = s.charAt(i);
                    if (!node.contains(key)) break;
                    node = node.map.get(key);
                    if (node.value != null) {
                        if (i + 1 == s.length()) {
                            rs.add(node.value);
                        } else {
                            List<String> temp = helper(s, i + 1, root);
                            for (String ss : temp) {
                                rs.add(node.value + " " + ss);
                            }
                        }
                    }
                }
                cache.put(start, rs);
            }
            
            return cache.get(start);
        } 
    
    }
    
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
