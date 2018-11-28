package com.ray.LintCode;

import com.ray.io.Out;

public class L_0041_Maximum_Subarray {

    static class Solution {
        /**
         * @param nums: A list of integers
         * @return: A integer indicate the sum of max subarray
         */
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
