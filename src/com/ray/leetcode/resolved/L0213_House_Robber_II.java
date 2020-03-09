package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * House Robber II
 * -----------------------------------------------------------------------------
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 *
 * Example:
 *      Example 1
 *      Input: [2,3,2]
 *      Output: 3
 *      Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
 *                   because they are adjacent houses.
 *      Example 2
 *      Input: [1,2,3,1]
 *      Output: 4
 *      Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 *                   Total amount you can rob = 1 + 3 = 4.
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/house-robber-ii/
 * @since   2020-03-09 21:15:11
 */
public class L0213_House_Robber_II {
    /**
     * 抢劫
     * 0  - n-2
     * 1  - n-1
     * 选择最大值
     */
    static class Solution {
        public int rob(int[] nums) {
            if (nums.length == 1) return nums[0];
            return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
        }

        public int rob(int[] nums, int start, int end) {
            int s = 0, w = 0, pres = 0;
            for (int i = start; i <= end; i++) {
                pres = s;
                s = w + nums[i];
                w = Math.max(w, pres);
            }
            return Math.max(s, w);
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
