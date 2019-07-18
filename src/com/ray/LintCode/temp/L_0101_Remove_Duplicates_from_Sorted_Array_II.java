package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a sorted array, remove the duplicates in place such that each element appear at most twice and return the new length.
 *      If a number appears more than two times, then keep the number appears twice in array after remove.
 *
 * 用例：
 *      ```
 *      Example 1:
 *      	Input: []
 *      	Output: 0
 *      
 *      
 *      Example 2:
 *      	Input:  [1,1,1,2,2,3]
 *      	Output: 5
 *      	
 *      	Explanation: 
 *      	the length is 5: [1,1,2,2,3]
 *      
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/remove-duplicates-from-sorted-array-ii/description
 * @date   2019-07-11 18:30:33
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
