package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Implement strStr()
 *
 * Implement strStr().
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Example:
 *      Example 1
 *      Input: haystack = hello, needle = ll
 *      Output: 2
 *      Example 2
 *      Input: haystack = aaaaa, needle = bba
 *      Output: -1
 *      Clarification:
 *      What should we return when needle is an empty string? This is a great question to ask during an interview.
 *      For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/implement-strstr/
 * @since   2020-02-25 22:43:48
 */
public class L0028_Implement_strStr {
    /**
     * 暴力搜索的复杂度时 O(m*n)
     * KMP构建了搜索数组后，时间复杂度为O(n)，但是KMP算法过于复杂，难于理解。
     */
    static class Solution {
        public int strStr(String source, String target) {
            int j,M = target.length();
            int i,N = source.length();
            for (i = 0, j = 0; i < N && j < M; i ++) {
                if (source.charAt(i) == target.charAt(j)) {
                    j ++;
                } else {
                    // 回退本次查找
                    i -= j;
                    j = 0;
                }
            }
            if (j == M) return i - M;
            else        return -1;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
