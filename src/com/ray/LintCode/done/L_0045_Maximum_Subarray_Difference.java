package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      Given an array with integers.
 *      
 *      Find two *non-overlapping* subarrays *A* and *B*, which `|SUM(A) - SUM(B)|` is the largest.
 *      
 *      Return the largest difference.
 *
 * 用例：
 *      Example 1:
 *      ```
 *      Input:[1, 2, -3, 1]
 *      Output:6
 *      Explanation:
 *      The subarray are [1,2] and [-3].So the answer is 6.
 *      ```
 *      
 *      Example 2:
 *      ```
 *      Input:[0,-1]
 *      Output:1
 *      Explanation:
 *      The subarray are [0] and [-1].So the answer is 1.
 *      ```
 *
 * 挑战：
 *      O(n) time and O(n) space.
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/maximum-subarray-difference/description
 * @date   2019-07-11 17:58:10
 */
public class L_0045_Maximum_Subarray_Difference {

    static class Solution {
        
        /**
         * @param nums: A list of integers
         * @return: An integer indicate the value of maximum difference between two substrings
         */
        public int maxDiffSubArrays(int[] nums) {
            
            int N = nums.length;
            
            int[] leftMin = new int[N];
            int[] leftMax = new int[N];
            int[] rightMin = new int[N];
            int[] rightMax = new int[N];
            
            int minSum,maxSum;
            minSum = maxSum = leftMin[0] = leftMax[0] = nums[0];
            for (int i = 1; i < N; i++) {
                minSum = Math.min(nums[i], minSum + nums[i]);
                leftMin[i] = Math.min(minSum, leftMin[i-1]);
                
                maxSum = Math.max(nums[i], maxSum + nums[i]);
                leftMax[i] = Math.max(maxSum, leftMax[i-1]);
                
            }
            
            minSum = maxSum = rightMin[N-1] = rightMax[N-1] = nums[N-1];
            for (int i = N-2; i >= 0; i--) {
                minSum = Math.min(nums[i], minSum + nums[i]);
                rightMin[i] = Math.min(minSum, rightMin[i+1]);
                
                maxSum = Math.max(nums[i], maxSum + nums[i]);
                rightMax[i] = Math.max(maxSum, rightMax[i+1]);
            }
         
            int max = Integer.MIN_VALUE;
            
            for (int i = 0; i < N-1; i++) {
                int t = Math.max(Math.abs(leftMin[i] - rightMax[i+1]), Math.abs(leftMax[i]-rightMin[i+1]));
                max = Math.max(max, t);
            }
            
            return max;
        }
        
    }
    
    public static void main(String[] args) {
        
        int[] nums = {1, 2, -3, 1};
        
        Out.p(new Solution().maxDiffSubArrays(nums));
        
    }
    
}