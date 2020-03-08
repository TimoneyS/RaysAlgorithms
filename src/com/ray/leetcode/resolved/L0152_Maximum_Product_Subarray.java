package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Maximum Product Subarray
 * -----------------------------------------------------------------------------
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 *
 * Example:
 *      Example 1
 *      Input: [2,3,-2,4]
 *      Output: 6
 *      Explanation: [2,3] has the largest product 6.
 *      Example 2
 *      Input: [-2,0,-1]
 *      Output: 0
 *      Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/maximum-product-subarray/
 * @since   2020-03-07 21:27:24
 */
public class L0152_Maximum_Product_Subarray {
    static class Solution {
        public int maxProduct(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            int minPre = nums[0], maxPre = nums[0];
            int    max = nums[0],    min = nums[0];
            int rs = nums[0];
            for (int i = 1; i < nums.length; i ++) {
                max = Math.max(nums[i], Math.max(maxPre * nums[i], minPre * nums[i]));
                min = Math.min(nums[i], Math.min(maxPre * nums[i], minPre * nums[i]));
                rs = Math.max(rs, max);
                maxPre = max;
                minPre = min;
            }
            return rs;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
