package com.ray.leetcode;

import com.ray.io.Out;

/**
 * Remove Duplicate Letters
 * -----------------------------------------------------------------------------
 * Given a string which contains only lowercase letters, remove duplicate letters so that every letter appears once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.
 *
 * Example:
 *      Example 1
 *      Input: bcabc
 *      Output: abc
 *      Example 2
 *      Input: cbacdcbc
 *      Output: acdb
 *      Note: This question is the same as 1081: https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/remove-duplicate-letters/
 * @since   2020-03-11 19:15:10
 */
public class L0316_Remove_Duplicate_Letters {
    /**
     * 字典序最小表示，越小的字符串越靠前
     */
    static class Solution {

        public String removeDuplicateLetters(String s) {
            int[] count = new int[26];
            for (int i = 0; i < s.length();i++) count[s.charAt(i)-'a'] ++;
            boolean[] marked = new boolean[26];
            StringBuilder sb = new StringBuilder();
            int l = 0;
            for (int i = 0; i < s.length();i++) {
                char c = s.charAt(i);
                count[c-'a'] --;
                if (marked[c - 'a']) continue;
                while (l > 0 && c <= sb.charAt(l-1) && count[sb.charAt(l-1)-'a'] > 0) {
                    marked[sb.charAt(l-1)-'a'] = false;
                    sb.deleteCharAt(l-1);
                    l --;
                }
                sb.append(c);
                l++;
                marked[c-'a'] = true;
            }
            return sb.toString();
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
