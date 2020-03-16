package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Compress String LCCI
 * -----------------------------------------------------------------------------
 * Implement a method to perform basic string compression using the counts of repeated characters.
 * For example, the string aabcccccaaa would become a2blc5a3. If the compressed string would not become smaller than
 * the original string, your method should return the original string. You can assume the string has only uppercase and
 * lowercase letters (a - z).
 *
 * Example:
 *      Example 1
 *      Input: aabcccccaaa
 *      Output: a2b1c5a3
 *      Example 2
 *      Input: abbccd
 *      Output: abbccd
 *      Explanation: 
 *      The compressed string is a1b2c2d1, which is longer than the original string.
 *      Note:
 *      	0 <= S.length <= 50000
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/compress-string-lcci/
 * @since   2020-03-16 22:47:23
 */
public class L100161_Compress_String_LCCI {
    static class Solution {
        public String compressString(String S) {
            StringBuilder sb = new StringBuilder();
            char prev  = ' ';
            int count = 0;
            for (int i = 0; i <= S.length(); i++) {
                if (i == S.length() || prev != ' ' && prev != S.charAt(i)) {
                    sb.append(prev).append(count);
                    count = 0;
                }
                if (i < S.length()) {
                    prev = S.charAt(i);
                    count++;
                }
            }
            return sb.length() >= S.length() ? S : sb.toString();
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
