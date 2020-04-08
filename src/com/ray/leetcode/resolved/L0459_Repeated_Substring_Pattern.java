package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Repeated Substring Pattern
 * -----------------------------------------------------------------------------
 * Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
 *
 * Example:
 *      Example 1
 *      Input: abab
 *      Output: True
 *      Explanation: It's the substring ab twice.
 *      Example 2
 *      Input: aba
 *      Output: False
 *      Example 3
 *      Input: abcabcabcabc
 *      Output: True
 *      Explanation: It's the substring abc four times. (And the substring abcabc twice.)
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/repeated-substring-pattern/
 * @since   2020-04-08 22:06:08
 */
public class L0459_Repeated_Substring_Pattern {
    static class Solution {
        public boolean repeatedSubstringPattern(String s) {
            for (int l = 1; l <= s.length() / 2; l ++) {
                if (s.length() % l != 0 || s.charAt(0) != s.charAt(l)) continue;
                OK:
                for (int i = l; i < s.length(); i += l) {
                    for (int j = 0; j < l; j ++) {
                        if (s.charAt(j) != s.charAt(i+j)) break OK;
                        if (i+j == s.length() - 1) return true;
                    }
                }
            }
            return false;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
