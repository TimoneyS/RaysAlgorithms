package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Palindrome Partitioning II
 * -----------------------------------------------------------------------------
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return the minimum cuts needed for a palindrome partitioning of s.
 *
 * Example:
 *      Example 1
 *      Input: aab
 *      Output: 1
 *      Explanation: The palindrome partitioning [aa,b] could be produced using 1 cut.
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/palindrome-partitioning-ii/
 * @since   2020-03-07 20:14:53
 */
public class L0132_Palindrome_Partitioning_II {
    /**
     * 动态规划
     * 设 dp[i] 表示从 0 到 i 最小切割次数
     * dp[i] = min { dp[j-1] + 1 } (s[j, i] is palindrome)
     */
    static class Solution {
        public int minCut(String s) {
            int[] dp = new int[s.length()];
            boolean[][] isPalindrome = new boolean[s.length()][s.length()];
            for (int i = 0; i < s.length(); i++) {
                dp[i] = i;
                for (int j = 0; j <= i; j++) {
                    if (s.charAt(i) == s.charAt(j) && (i-j < 2 || isPalindrome[i-1][j+1])) {
                        isPalindrome[i][j] = true;
                        dp[i] = j == 0 ? 0 : Math.min(dp[i], dp[j-1] + 1);
                    }
                }
            }
            return dp[s.length()-1];
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
