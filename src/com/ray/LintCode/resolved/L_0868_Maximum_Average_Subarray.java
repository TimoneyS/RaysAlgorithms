package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 给定 n 个整数构成的数组，寻找长度为 k 的平均数最大的数组。返回平均数
 *
 *
 * @author rays1
 *
 */
public class L_0868_Maximum_Average_Subarray {

    /**
     * 寻找长度为 k 的和最大的子数组即可
     * @author rays1
     *
     */
    static class Solution {
    
        public double findMaxAverage(int[] nums, int k) {
            int sum = 0;
            for (int i = 0; i < k; i++) sum += nums[i];
            int maxSum = sum;
            for (int i = k; i < nums.length; i++)
                maxSum = Math.max( (sum = sum + nums[i] - nums[i-k]), maxSum);
            
            return maxSum * 1.0 / k;
        }
    
    }
    
    public static void main(String[] args) {
        
        int[] nums = {1,12,-5,-6,50,3};
        int k = 4;
        
        Out.p(new Solution().findMaxAverage(nums, k));
        
    }

}
