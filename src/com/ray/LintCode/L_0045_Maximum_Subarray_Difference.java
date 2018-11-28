package com.ray.LintCode;

/**
 * Given an array with integers.
 * 
 * Find two non-overlapping subarrays A and B, which |SUM(A) - SUM(B)| is the largest.
 * 
 * Return the largest difference.
 * 
 * <p>
 * Example : For [1, 2, -3, 1], return 6.
 * <p>
 * challenge : O(n) time and O(n) space.
 * @author rays1
 *
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
            
            int sum = 0;
            
            
            
            
            
            
            
            return 0;
        }
        
    }

}
