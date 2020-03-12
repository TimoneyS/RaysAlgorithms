package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Integer Break
 * -----------------------------------------------------------------------------
 * Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.
 *
 * Example:
 *      Example 1
 *      Input: 2
 *      Output: 1
 *      Explanation: 2 = 1 + 1, 1 &times; 1 = 1.
 *      Example 2
 *      Input: 10
 *      Output: 36
 *      Explanation: 10 = 3 + 3 + 4, 3 &times; 3 &times; 4 = 36.
 *      Note: You may assume that n is not less than 2 and not larger than 58.
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/integer-break/
 * @since   2020-03-12 22:39:25
 */
public class L0343_Integer_Break {
    static class Solution {
        public int integerBreak(int n) {
            long[] dp = new long[n+1];
            dp[0] = 1;
            dp[1] = 1;
            dp[2] = 1;
            for (int i = 3; i <= n; i++) {
                for (int j = 1; j < i; j++) {
                    dp[i] = Math.max(dp[i], j * (i-j));
                    dp[i] = Math.max(dp[i], j * dp[i-j]);
                }
            }
            return (int) dp[n];
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
