package com.ray.LintCode.resolved;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ray.io.Out;
import com.ray.util.Timer;

/**
 * 给定一个字符串和一个字典，使用空格短距，使得断句后的每个单词都在字典中。
 * 
 * 返回所有可能的断句方式
 *
 * 例如：
 *      字符串     lintcode,
 *      字    典    ["de", "ding", "co", "code", "lint"].
 *      返    回    ["lint code", "lint co de"].
 *
 * @author rays1 
 *
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
        
        String s = "aaaa";
        Set<String> wordDict = new HashSet<>();
        
        wordDict.addAll(Arrays.asList(new String[] {
                "a","aa","aaa"
        }));
        
        Timer.CLICK();
        Out.p(new Solution().wordBreak(s, wordDict).size());
        Timer.CLICK();
        
    }

}
