package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Combination Sum IV
 * -----------------------------------------------------------------------------
 * Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.
 *
 * Example:
 *      Example 1
 *      nums = [1, 2, 3]
 *      target = 4
 *      The possible combination ways are:
 *      (1, 1, 1, 1)
 *      (1, 1, 2)
 *      (1, 2, 1)
 *      (1, 3)
 *      (2, 1, 1)
 *      (2, 2)
 *      (3, 1)
 *      Note that different sequences are counted as different combinations.
 *      Therefore the output is 7.
 *      Follow up:
 *      What if negative numbers are allowed in the given array?
 *      How does it change the problem?
 *      What limitation we need to add to the question to allow negative numbers?
 *      Credits:
 *      Special thanks to @pbrother for adding this problem and creating all test cases.
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/combination-sum-iv/
 * @since   2020-03-23 21:47:16
 */
public class L0377_Combination_Sum_IV {
    /**
     * 设 dp[i][j] 表示 第一个数字为 nums[i] 和为 j 的组合总数
     *
     *  dp[i][j] = sum{ dp[k][j-nums[i]] } k = (0, n)
     *
     *  因为对于每一层的 k 算法都是求和，可以缩减空间到 1 维
     *   dp[j] = sum { d[j-nums[k]] }  k = (0, n)
     */
    static class Solution {
        public int combinationSum4(int[] nums, int target) {
            int[] dp = new int[target + 1];
            dp[0] = 1;
            for (int j = 1; j <= target; j++)
                for (int num : nums) {
                    if (j >= num) dp[j] += dp[j - num];
                }
            return dp[target];
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
