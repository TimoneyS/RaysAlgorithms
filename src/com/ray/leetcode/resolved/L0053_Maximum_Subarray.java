package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Maximum Subarray
 *
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * Example:
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 *
 * Example:
 *      
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/maximum-subarray/
 * @since   2020-02-27 22:24:06
 */
public class L0053_Maximum_Subarray {
    /**
     * 设 sum[i] 表示以 i 结束的和最大子数组之和
     *
     * 则有
     *      sum[i+1] = max(sum[i], 0) + nums[i+1]
     * 最终的结果为
     *      rs = max { sum[0], sum[1], ... , sum[n-1] }
     *
     * 则算法如下
     *
     * // 计算 sum 数组
     * for (int i = 1; i < n; i++)
     *      sum[i] = Math.max(sum[i-1], 0) + nums[i]
     *
     * // 再计算结果
     * for (int s : sum)
     *      rs = Math.max(rs, s);
     *
     * 实际上算法可以优化空间复杂度，每次计算出一个新的和立即和保存的最大和比较即可，并不需要保存所有的 sum
     *
     * for (int i = 1; i < n; i++)
     *      sum = Math.max(sum, 0) + nums[i]
     *      rs = Math.max(rs, sum);
     */
    static class Solution {
        public int maxSubArray(int[] nums) {
            int max = Integer.MIN_VALUE, sum = 0;
            for (int i = 0; i < nums.length; i++) {
                max = Math.max((sum = Math.max(0, sum) + nums[i]), max);
            }
            return max;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
