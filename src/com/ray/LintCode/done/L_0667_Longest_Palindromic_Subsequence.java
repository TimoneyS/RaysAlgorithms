package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is `1000`.
 *
 * 用例：
 *      **Example1**
 *      ```
 *      Input: "bbbab"
 *      Output: 4
 *      Explanation:
 *      One possible longest palindromic subsequence is "bbbb".
 *      ```
 *      **Example2**
 *      ```
 *      Input: "bbbbb"
 *      Output: 5
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/longest-palindromic-subsequence/description
 * @date   2019-07-11 18:35:17
 */
public class L_0667_Longest_Palindromic_Subsequence {

    /**
     * 标准动态规划
     * 
     * dp[i][j] 表示 i, j  之间的最长回文子序列
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        int[][] mem;
        
        public int longestPalindromeSubseq(String s) {
            if (s == null || s.equals("")) return 0;
            
            mem = new int[s.length()][s.length()];
            return dp(s, 0, s.length()-1);
        }
        
        int dp(String s, int i, int j) {
            if (mem[i][j] == 0) {
                if (j <= i) {
                    mem[i][j] = j-i+1;
                } else if (s.charAt(i) == s.charAt(j)) {
                    mem[i][j] = 2 + dp(s,i+1, j-1);
                } else {
                    mem[i][j] = Math.max(dp(s,i+1, j), dp(s,i, j-1));
                }
            }
            return mem[i][j];
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
