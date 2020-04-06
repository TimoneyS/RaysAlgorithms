package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Longest Common Subsequence
 * -----------------------------------------------------------------------------
 * Given two strings text1 and text2, return the length of their longest common subsequence.
 * A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted without changing the relative order of the remaining characters. (eg, ace is a subsequence of abcde while aec is not). A common subsequence of two strings is a subsequence that is common to both strings.
 * If there is no common subsequence, return 0.
 *
 * Example:
 *      Example 1
 *      Input: text1 = abcde, text2 = ace 
 *      Output: 3  
 *      Explanation: The longest common subsequence is ace and its length is 3.
 *      Example 2
 *      Input: text1 = abc, text2 = abc
 *      Output: 3
 *      Explanation: The longest common subsequence is abc and its length is 3.
 *      Example 3
 *      Input: text1 = abc, text2 = def
 *      Output: 0
 *      Explanation: There is no such common subsequence, so the result is 0.
 *      Constraints:
 *      	1 <= text1.length <= 1000
 *      	1 <= text2.length <= 1000
 *      	The input strings consist of lowercase English characters only.
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/longest-common-subsequence/
 * @since   2020-04-06 23:08:08
 */
public class L1250_Longest_Common_Subsequence {
    /**
     * dp(i, j) 表示 字符串A从i开始，字符串B从j开始的最长公共子序列长度
     *
     * 如果 A[i] == B[j] 则 dp(i, j) = 1 + dp(i+1, j+1)
     * 否则 dp(i, j) = max {
     *          dp(i+1, j),
     *          dp(i, j+1)
     * }
     */
    static class Solution {
        public int longestCommonSubsequence(String A, String B) {
            if (A.length() == 0 || B.length() == 0) return 0;
            int[][] mem = new int[A.length()+1][B.length()+1];
            for (int i = A.length()-1; i >= 0; i--) {
                for (int j = B.length()-1; j >= 0; j--) {
                    mem[i][j] = A.charAt(i) == B.charAt(j) ?
                            1 + mem[i+1][j+1] :
                            Math.max(mem[i+1][j], mem[i][j+1]);
                }
            }
            return mem[0][0];
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
