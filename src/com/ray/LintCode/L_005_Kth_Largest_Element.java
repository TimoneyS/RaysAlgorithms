package com.ray.LintCode;

import java.util.Arrays;

/**
 * Find K-th largest element in an array.
 * 
 * @author rays1
 *
 */
public class L_005_Kth_Largest_Element {
    
    static class Solution {
        /**
         * @param n: An integer
         * @param nums: An array
         * @return: the Kth largest element
         */
        public int kthLargestElement(int n, int[] nums) {
            // write your code here
            Arrays.sort(nums);
            return nums[nums.length-n];
            
        }
    }
    
}
