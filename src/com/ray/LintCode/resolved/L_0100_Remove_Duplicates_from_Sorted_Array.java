package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * 
 * @author rays1
 *
 */
public class L_0100_Remove_Duplicates_from_Sorted_Array {

    
    static class Solution {
        
        /*
         * @param nums: An ineger array
         * @return: An integer
         */
        public int removeDuplicates(int[] nums) {
            int l = nums.length;
            
            int i = 1;
            int dup_w = 0;
            while (i < l) {
                if (nums[i] == nums[i-1]) {
                    dup_w ++;
                } else {
                    if (dup_w > 0) {
                        moveLeft(nums, i, l-1, dup_w);
                        l -= dup_w;
                        i -= dup_w;
                        dup_w = 0;
                    }
                }
                i++;
            }
            l -= dup_w;
            
            return l;
        }
        
        /**
         * 向左移动数组
         * @param arr
         * @param start
         * @param step
         */
        public void moveLeft(int[] arr, int start, int end, int step) {
            for (int i = start; i <= end; i++) {
                arr[i-step] = arr[i];
            }
        }
        
    }
    
    public static void main(String[] args) {
        
        int[] arr = {1,1,1,1,2,3,3};
        
        int rs = new Solution().removeDuplicates(arr);
        
        Out.p(arr);
        Out.p(rs);
        
    }

}
