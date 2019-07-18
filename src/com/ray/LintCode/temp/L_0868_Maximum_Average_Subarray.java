package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      Given an array consisting of `n` integers, find the contiguous subarray of given length `k` that has the maximum average value. You need to output the maximum average value.
 *
 * 用例：
 *      **Example1**
 *      
 *      ```
 *      Input:  nums = [1,12,-5,-6,50,3] and k = 4
 *      Output: 12.75
 *      Explanation:
 *      Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
 *      ```
 *      
 *      **Example2**
 *      
 *      ```
 *      Input:  nums = [4,2,1,3,3] and k = 2
 *      Output: 3.00
 *      Explanation:
 *      Maximum average is (3+3)/2 = 6/2 = 3.00
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/maximum-average-subarray/description
 * @date   2019-07-11 18:38:07
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
        
        Out.p(new Solution());
        
    }

}
