package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      给定字符串 s, 需要将它分割成一些子串, 使得每个子串都是回文串.
 *      最少需要分割几次?
 * 用例：
 *      **Example 1:**
 *      Input: "a"
 *      Output: 0
 *      Explanation: "a" is already a palindrome, no need to split.
 *
 *      **Example 2:**
 *      Input: "aab"
 *      Output: 1
 *      Explanation: Split "aab" once, into "aa" and "b", both palindrome.
 * 难度： Medium
 *   
 * @author rays1
 * @link   https://www.lintcode.cn/problem/palindrome-partitioning-ii/description
 * @since  2019-07-11 18:30:39
 */
public class L_0108_Palindrome_Partitioning_II {
    /**
     * 动态规划
     * 设 dp[i] 表示从 0 到 i 最小切割次数
     *
     * dp[i] = min { dp[j-1] + 1 } (s[j, i] is palindrome)
     *
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

    static class Solution2 {
        int[] mem;
        public int minCut(String s) {
            mem = new int[s.length()];
            return minCut(s, 0, s.length()-1) - 1;
        }
        
        public int minCut(String s, int start, int end) {
            if (start == end) return 1;
            if (start > end) return 0;
            if (mem[start] != 0) return mem[start];
            int min = Integer.MAX_VALUE;
            for (int i = start; i <= end; i++) {
                if (isPalindrome(s, start, i)) {
                    min = Math.min(min, minCut(s, i+1, end));
                }
            }
            mem[start] = 1 + min;
            return mem[start];
        }
        
        boolean isPalindrome(String s, int start, int end) {
            int l = start, r = end;
            while(l < r)
                if(s.charAt(l++) != s.charAt(r--))
                    return false;
            return true;
        }
    }
    
    public static void main(String[] args) {
        String s = "aaabaa";
        Out.p(new Solution().minCut(s));
        Out.p(new Solution2().minCut(s));
    }
}