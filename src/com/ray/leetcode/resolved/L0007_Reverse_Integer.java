package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Reverse Integer
 *
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example:
 *      Example 1
 *      Input: 123
 *      Output: 321
 *      Example 2
 *      Input: -123
 *      Output: -321
 *      Example 3
 *      Input: 120
 *      Output: 21
 *      Note:
 *      Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [&minus;231,&nbsp; 231&nbsp;&minus; 1].
 *      For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/reverse-integer/
 * @since   2020-02-23 19:01:55
 */
public class L0007_Reverse_Integer {
    static class Solution {
        public int reverse(int x) {
            boolean isPos = x > 0;
            if (x < 0) x = -x;
            double d = 0;
            while (x > 0) {
                d = d*10 + x %10;
                x = x / 10;
            }
            d = isPos ? d : -d;
            if (d > Integer.MAX_VALUE || d < Integer.MIN_VALUE) d = 0;
            return (int)d;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
