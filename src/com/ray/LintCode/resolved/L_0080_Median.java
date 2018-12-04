package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * Given a unsorted array with integers, find the median of it.
 * A median is the middle number of the array after it is sorted.
 * If there are even numbers in the array, return the N/2-th number after sorted.
 * 
 * @author rays1
 *
 */
public class L_0080_Median {

    static class Solution {
        
        /**
         * @param nums: A list of integers
         * @return: An integer denotes the middle number of the array
         */
        public int median(int[] nums) {
            return quickSelect(nums, (nums.length-1)/2, 0, nums.length-1);
        }
        
        public int quickSelect(int[] nums, int n, int s, int t) {
            
            int l = s + 1;
            int r = t;
            while (true) {
                while (r > s && nums[s] <= nums[r]) r --;
                while (l < t && nums[l] < nums[s]) l ++;
                if (r > l) swap(nums, r, l);
                else break;
            }
            swap(nums, r, s);
            
            if (r == n)
                return nums[r];
            else if (r > n)
                return quickSelect(nums, n, s, r-1);
            else 
                return quickSelect(nums, n, r+1, t);
        }
        
        private void swap(int[] nums, int i, int j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
        
    }
    
    public static void main(String[] args) {
        
        int[] nums = {0,-2,0,-3,-4,0,0,0};
        
        Out.p(new Solution().median(nums));
        
    }
    
}
