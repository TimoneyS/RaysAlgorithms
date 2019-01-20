package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 给定一个整数数组，找到一个具有最大总和的连续子数组。
 * 返回子数组的数字之和
 * 
 * 
 *
 */
public class L_0041_Maximum_Subarray {

    static class Solution {
        
        public int maxSubArray(int[] nums) {
            int max = Integer.MIN_VALUE, sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum = Math.max(nums[i], sum + nums[i]);
                max = Math.max(sum, max);
            }
            return max;
        }
        
    }
    
    public static void main(String[] args) {
        
        int[] nums = {-1, -2, -3};
        
        Out.p(new Solution().maxSubArray(nums));
        
    }

}
