package com.ray.leetcode;

import com.ray.io.Out;

/**
 * Burst Balloons
 * -----------------------------------------------------------------------------
 * Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.
 * Find the maximum coins you can collect by bursting the balloons wisely.
 * Note:
 * 	You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
 * 	0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 *
 * Example:
 *      Example 1
 *      Input: [3,1,5,8]
 *      Output: 167 
 *      Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 *                   coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/burst-balloons/
 * @since   2020-03-11 19:16:21
 */
public class L0312_Burst_Balloons {
    static class Solution {

        public int maxCoins(int[] v) {
            int n = v.length;
            int[] t = v;
            v = new int[n+2];
            System.arraycopy(t, 0, v, 1, n);

            v[0] = 1;
            v[n+1] = 1;

            int[][] dp = new int[n+2][n+2];

            for (int len = 1; len <= n; ++len) {
                for (int i = 1; i <= n - len + 1; ++i) {
                    int j = i + len - 1;
                    for (int k = i; k <= j; ++k) {
                        dp[i][j] = Math.max(dp[i][j], v[i - 1] * v[k] * v[j + 1] + dp[i][k - 1] + dp[k + 1][j]);
                    }
                }
            }
            return dp[1][n];
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
