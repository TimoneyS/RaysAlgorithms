package com.ray.LintCode.resolved;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import com.ray.io.Out;

/**
 * 给定一个单词字典和一个移除了所有空格的句子。
 * 
 * 返回所有可能的断句方式，并且断句后句子中的单词均在字典中能够找到。
 * 
 * 示例
 *      输入  
 *          "banana"
 *          ["b", "ba", "na", "ana"]
 *      输出
 *          2
 *          [ba na na]
 *          [b ana na]
 *          
 * @author rays1
 * @url    https://www.lintcode.com/problem/word-break-iii/description
 */
public class L_0683_Word_Break_III {
    
    /**
     * 假设 dp[i] 为 从 i 开始的次数
     * 
     * dp[i] = sum { n(str[i, k]) * dp[i-k-1] } ( i < k < s.leength ) 
     * 
     * 评级别的算法，题目要求不区分大小写，其实可以通过字符串范围来规避，这里偷懒使用了 toLowerCase 全部转换成小写来规避。
     * 
     */
    static class Solution {
        
        class TrieNode {
            String val = null;
            HashMap<Character, TrieNode> adj = new HashMap<>();
        }
        
        public int wordBreak3(String s, Set<String> dict) {
            TrieNode root = new TrieNode();
            for (String word : dict)
                add(root, word.toLowerCase(), 0);
            
            int[] dp = new int[s.length()+1];
            dp[s.length()] = 1;
            
            s = s.toLowerCase();
            for (int k = s.length()-1; k >= 0; k--) {
                TrieNode node = root;
                for (int j = k; j < s.length(); j++) {
                    node = node.adj.get(s.charAt(j));
                    if (node == null) break;
                    else if (node.val == null) continue;
                    dp[k] += dp[j+1];
                }
            }
            
            return dp[0];
        }

        private void add(TrieNode node, String word, int start) {
            if (start == word.length()) {
                node.val = word;
                return;
            }
            char c = word.charAt(start);
            if (!node.adj.containsKey(c)) {
                node.adj.put(c, new TrieNode());
            }
            add(node.adj.get(c), word, start+1);
        }
    
    }
    
    public static void main(String[] args) {
        
        String s = "Catmat";
        HashSet<String> dict = new HashSet<String>(Arrays.asList(new String[] {
                "Cat","mat","Ca","tm","at","C","Dog","og","Do"
                }));
        
        Out.p(new Solution().wordBreak3(s, dict));
        
    }

}
