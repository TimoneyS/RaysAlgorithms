package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Add Binary
 *
 * Given two binary strings, return their sum (also a binary string).
 * The input strings are both non-empty and contains only characters 1 or 0.
 *
 * Example:
 *      Example 1
 *      Input: a = 11, b = 1
 *      Output: 100
 *      Example 2
 *      Input: a = 1010, b = 1011
 *      Output: 10101
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/add-binary/
 * @since   2020-02-27 23:18:09
 */
public class L0067_Add_Binary {
    static class Solution {
        public String addBinary(String a, String b) {
            StringBuilder sb = new StringBuilder();

            int s1 = a.length()-1, s2 = b.length()-1;

            char prev = '0';
            while (s1 >= 0 || s2 >= 0) {

                char c1 = s1 >= 0 ? a.charAt(s1--) : '0';
                char c2 = s2 >= 0 ? b.charAt(s2--) : '0';

                char rs = '0';
                if (c1 == c2) {
                    rs = prev;
                    prev = c1;
                } else {
                    rs = (prev == '0') ? '1' : '0';
                }
                sb.insert(0, rs);
            }

            if (prev == '1')
                sb.insert(0, prev);

            return sb.toString();
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
