package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      Given an unsorted array `nums`, reorder it **in-place** such that 
 *      
 *      ```
 *      nums[0] <= nums[1] >= nums[2] <= nums[3]....
 *      ```
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: [3, 5, 2, 1, 6, 4]
 *      Output: [1, 6, 2, 5, 3, 4]
 *      Explanation: This question may have multiple answers, and [2, 6, 1, 5, 3, 4] is also ok.
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input: [1, 2, 3, 4]
 *      Output: [1, 4, 2, 3]
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/wiggle-sort/description
 * @date   2019-07-11 18:33:40
 */
public class L_0508_Wiggle_Sort {

    static class Solution {
        /**
         * @param nums a list of integer
         * @return void
         */
        public void wiggleSort(int[] nums) {

            for (int i = 0; i < nums.length; i++) {
                if(i % 2 == 0) swap(nums, i, min(nums, i, nums.length));
                if(i % 2 == 1) swap(nums, i, max(nums, i, nums.length));
            }

        }
        
        public void swap(int[] arr, int i, int j) {
            if (i==j) return;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        
        public int min(int[] arr, int l, int r) {
            int min = l;
            for (int i = l; i < r; i++) {
                if(arr[min] > arr[i]) min = i;
            }
            return min;
        }
        
        public int max(int[] arr, int l, int r) {
            int max = l;
            for (int i = l; i < r; i++) {
                if(arr[max] < arr[i]) max = i;
            }
            return max;
        }

    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
