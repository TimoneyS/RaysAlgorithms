package com.ray.LintCode.temp;

import java.util.HashMap;
import java.util.Set;

import com.ray.io.Out;

/**
 * 描述：
 *      Give a dictionary of words and a sentence with all whitespace removed, return the number of sentences you can form by inserting whitespaces to the sentence so that each word can be found in the dictionary.
 *
 * 用例：
 *      **Example1**
 *      ```
 *      Input:
 *      "CatMat"
 *      ["Cat", "Mat", "Ca", "tM", "at", "C", "Dog", "og", "Do"]
 *      Output: 3
 *      Explanation:
 *      we can form 3 sentences, as follows:
 *      "CatMat" = "Cat" + "Mat"
 *      "CatMat" = "Ca" + "tM" + "at"
 *      "CatMat" = "C" + "at" + "Mat"
 *      ```
 *      **Example1**
 *      ```
 *      Input:
 *      "a"
 *      []
 *      Output: 0
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/word-break-iii/description
 * @date   2019-07-11 18:35:27
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
        
        Out.p(new Solution());
        
    }

}
