package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Longest Palindromic Substring
 *
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example:
 *      Example 1
 *      Input: babad
 *      Output: bab
 *      Note: aba is also a valid answer.
 *      Example 2
 *      Input: cbbd
 *      Output: bb
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/longest-palindromic-substring/
 * @since   2020-02-23 17:46:44
 */
public class L0005_Longest_Palindromic_Substring {
    /**
     * 在字符串中间插入占位字符，如 aa -> a#a  aba -> a#b#a
     * 这样保证所有的字符串都是奇数个数的字符串
     *
     * 然后计算每个字符为中心的回文半径 dp[i]
     * 如果 str[i + dp[i]] == str[i - dp[i]] 则 dp[i] 可以扩增半径
     */
    static class Solution {
        public String longestPalindrome(String s) {

            int[] p = new int[s.length()*2+1];
            char[] chs = new char[s.length()*2 + 1];
            for (int i = 0; i < chs.length; i++)
                chs[i] = i % 2 == 0 ? '#' : s.charAt(i/2);

            int mx = 0, id = 0, resLen = 0, resCenter = 0;
            for (int i = 0; i < chs.length; i++) {

                p[i] = mx > i ? Math.min(p[2 * id - i], mx - i) : 1;

                while (i + p[i] < chs.length && i - p[i] >= 0 && chs[i + p[i]] == chs[i - p[i]]) {
                    p[i]++;
                }
                // 中心移动
                if (mx < i + p[i]) {
                    mx = i + p[i];
                    id = i;
                }
                // 最大值判断
                if (resLen < p[i]) {
                    resLen = p[i];
                    resCenter = i;
                }

            }

            int idx = resCenter/2;
            int rad = resLen/2;

            if (chs[resCenter] != '#') {
                return s.substring(idx - rad+1, idx+rad);
            } else {
                return s.substring(idx - rad, idx+rad);
            }
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
