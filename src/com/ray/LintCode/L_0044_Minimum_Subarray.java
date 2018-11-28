package com.ray.LintCode;

import java.util.Arrays;
import java.util.List;

import com.ray.io.Out;

/**
 * Given an array of integers, find the subarray with smallest sum.
 * 
 * Return the sum of the subarray.
 * 
 * @author rays1
 *
 */
public class L_0044_Minimum_Subarray {

    
    static class Solution {
        /*
         * @param nums: a list of integers
         * @return: A integer indicate the sum of minimum subarray
         */
        public int minSubArray(List<Integer> nums) {
            return minSubArray(nums.toArray(new Integer[nums.size()]));
        }
        
        private int minSubArray(Integer[] nums) {
            int N = nums.length;
            int[] left = new int[N];
            
            int sum = nums[0];
            left[0] = nums[0];
            for (int i = 1; i < N; i++) {
                sum += nums[i];
                sum = Math.min(sum, nums[i]);
                left[i] = Math.min(sum, left[i-1]);
            }
            
            return left[N-1];
        }
        
    }
    
    static class Solution1 {
        /*
         * @param nums: a list of integers
         * @return: A integer indicate the sum of minimum subarray
         */
        public int minSubArray(List<Integer> nums) {
            if (nums == null || nums.size() == 0) return 0;
            
            int minSum = Integer.MAX_VALUE, maxSum = 0, sum = 0;
            for (int i = 0; i < nums.size(); i++) {
                sum += nums.get(i);
                minSum = Math.min(minSum, sum - maxSum);
                maxSum = Math.max(maxSum, sum);
            }
            
            return minSum;
        }
    }
    
    
    public static void main(String[] args) {
        
        List<Integer> nums = Arrays.asList(new Integer[] {1, -1, -2, 1});
        
        
        Out.p(new Solution().minSubArray(nums));
        Out.p(new Solution1().minSubArray(nums));
        
    }

}
