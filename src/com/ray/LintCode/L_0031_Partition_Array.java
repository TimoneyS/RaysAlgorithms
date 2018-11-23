package com.ray.LintCode;

import com.ray.io.Out;
import com.ray.util.ArrayUtil;

/**
 * 
 * Given an array nums of integers and an int k,
 * partition the array (i.e move the elements in "nums") such that:
 * <li> All elements < k are moved to the left
 * <li> All elements >= k are moved to the right 
 * <p>
 * Return the partitioning index, i.e the first index i nums[i] >= k.
 * 
 * @author rays1
 *
 */
public class L_0031_Partition_Array {
    static class Solution {
        
        /**
         * @param nums: The integer array you should partition
         * @param k: An integer
         * @return: The index after partition
         */
        public int partitionArray(int[] nums, int k) {
            if (nums.length == 0) return 0;
            
            int l = 0;
            int r = nums.length - 1;
            while (true) {
                while (nums[l] < k) {
                    l ++;
                    if (l >= nums.length) break;
                }
                while (nums[r] >= k && r > 0) r --;
                if (l < r) swap(nums, l, r);
                else break;
            }
            return l;
        }
        
        private void swap(int[] nums, int i, int j) {
            if (i == j) return;
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
        
    }
    
    public static void main(String[] args) {
        
        int[] nums = {};
        int k = 2;
        
        Out.p(nums);
        Out.p(new Solution().partitionArray(nums, k));
        Out.p(nums);
        
    }
    
}
