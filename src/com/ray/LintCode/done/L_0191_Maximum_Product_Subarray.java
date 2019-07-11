package com.ray.LintCode.done;

/**
 * 描述：
 *      Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input:[2,3,-2,4]
 *      Output:6
 *      ```
 *      
 *      **Example 2:**
 *      ```
 *      Input:[-1,2,4,1]
 *      Output:8
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/maximum-product-subarray/description
 * @date   2019-07-11 18:31:47
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
