package com.ray.LintCode.resolved;

/**
 * 寻找连续的乘积最大的子数组
 * 
 * [2,3,-2,4] -> [2,3], result = 6.
 * 
 * @author rays1
 *
 */
public class L_0191_Maximum_Product_Subarray {

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

}
