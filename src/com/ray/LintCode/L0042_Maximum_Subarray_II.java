package com.ray.LintCode;

import java.util.Arrays;
import java.util.List;

import com.ray.io.Out;

/**
 * Given an array of integers, find two non-overlapping subarrays which have the
 * largest sum. The number in each subarray should be contiguous. Return the
 * largest sum.
 * 
 * <p>
 * Example
 * <p>
 * For given [1, 3, -1, 2, -1, 2],
 *  the two subarrays are [1, 3] and [2, -1, 2] 
 *      or [1, 3, -1, 2] and [2],
 * they both have the largest sum 7.
 * 
 * @author rays1
 *
 */
public class L0042_Maximum_Subarray_II {
    
    static class Solution {
        
        /*
         * @param nums: A list of integers
         * @return: An integer denotes the sum of max two non-overlapping subarrays
         */
        public int maxTwoSubArrays(List<Integer> nums) {
            
            int N = nums.size();
            
            if (N == 2) return nums.get(0) + nums.get(N-1);
            
            int[] left = new int[N];
            int[] right = new int[N];
            
            int sum = nums.get(0);
            left[0] = nums.get(0);
            for (int i = 1; i < N; i++) {
                sum += nums.get(i);
                sum = Math.max(sum, nums.get(i));
                left[i] = Math.max(sum, left[i-1]);
            }
            
            sum = nums.get(N-1);
            right[N-1] = nums.get(N-1);
            for (int i = N-2; i >= 0; i--) {
                sum += nums.get(i);
                sum = Math.max(sum, nums.get(i));
                right[i] = Math.max(sum, right[i+1]);
            }
            
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < N-1; i++) {
                if (max < left[i] + right[i+1])
                    max = left[i] + right[i+1];
            }

            return max;
        }
        
    }
    
    public static void main(String[] args) {
        
        Integer[] nums = {0,-1};
        List<Integer> numsL = Arrays.asList(nums);
        
        
        int max = new Solution().maxTwoSubArrays(numsL);
        
        Out.p(max);
    }
    
}
