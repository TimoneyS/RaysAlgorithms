package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Shortest Palindrome
 * -----------------------------------------------------------------------------
 * Given a string s, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.
 *
 * Example:
 *      Example 1
 *      Input: aacecaaa
 *      Output: aaacecaaa
 *      Example 2
 *      Input: abcd
 *      Output: dcbabcd
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/shortest-palindrome/
 * @since   2020-03-09 21:16:26
 */
public class L0214_Shortest_Palindrome {
    /**
     * 倒序和正序比较，比较时采用指纹比较法，每次更新比较字符串的hash
     */
    static class Solution {
        public String shortestPalindrome(String s1) {
            // reverse
            StringBuilder sb = new StringBuilder();
            for (int i = s1.length()-1; i >= 0; i--) sb.append(s1.charAt(i));
            String s2 = sb.toString();
            //
            int hash1 = 0, hash2 = 0;
            int index = -1;
            for(int i = 0, j = s2.length()-1; i < s1.length(); i ++, j--) {
                hash1 = hash1 * 31 + s1.charAt(i);
                hash2 = hash2 + s2.charAt(j) * pow(31, i);
                if (hash1 == hash2) index = i;
            }
            return s2.substring(0, s2.length() - index - 1) + s1;
        }

        int pow(int n, int m) {
            if (m == 1) return n;
            if (m == 0) return 1;
            int c = pow(n, m/2);
            return c * c * pow(n, m - m/2 - m/2);
        }

    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
