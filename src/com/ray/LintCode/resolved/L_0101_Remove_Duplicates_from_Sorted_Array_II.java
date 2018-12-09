package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 *
 *
 * @author rays1
 *
 */
public class L_0101_Remove_Duplicates_from_Sorted_Array_II {

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
                    if (dup_w > 1) {
                        moveLeft(nums, i, l-1, dup_w-1);
                        l -= dup_w-1;
                        i -= dup_w-1;
                    }
                    dup_w = 0;
                }
                i++;
            }
            if (dup_w > 1)
                l -= dup_w-1;
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
        
        int[] arr = {1,1,2,2,2,3};
        
        int rs = new Solution().removeDuplicates(arr);
        
        Out.p(arr);
        Out.p(rs);
        
    }

}
