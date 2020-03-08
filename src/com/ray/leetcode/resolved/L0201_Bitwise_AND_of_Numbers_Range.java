package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Bitwise AND of Numbers Range
 * -----------------------------------------------------------------------------
 * Given a range [m, n] where 0 <= m <= n <= 2147483647,
 * return the bitwise AND of all numbers in this range, inclusive.
 *
 * Example:
 *      Example 1
 *      Input: [5,7]
 *      Output: 4
 *      Example 2
 *      Input: [0,1]
 *      Output: 0
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/bitwise-and-of-numbers-range/
 * @since   2020-03-08 21:58:31
 */
public class L0201_Bitwise_AND_of_Numbers_Range {
    static class Solution {
        public int rangeBitwiseAnd(int m, int n) {
            int rs = m;
            while (m < n) {
                rs &= m;
                m ++;
                if (rs == 0) break;
            }
            rs &= n;
            return rs;
        }
    }
    
    public static void main(String[] args) {
        int m = 2147483646;
        int n = 2147483647;

        Out.p(Integer.toBinaryString(m));
        Out.p(Integer.toBinaryString(n));

        Out.p(new Solution().rangeBitwiseAnd(m, n));
    }
}
