package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 *      
 *      (i.e., `0 1 2 4 5 6 7` might become `4 5 6 7 0 1 2`).
 *      
 *      Find the minimum element.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input：[4, 5, 6, 7, 0, 1, 2]
 *      Output：0
 *      Explanation：
 *      The minimum value in an array is 0.
 *      ```
 *      
 *      **Example 2:**
 *      ```
 *      Input：[2,1]
 *      Output：1
 *      Explanation：
 *      The minimum value in an array is 1.
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/find-minimum-in-rotated-sorted-array/description
 * @date   2019-07-11 18:31:21
 */
public class L_0159_Find_Minimum_in_Rotated_Sorted_Array {

    static class Solution {
        public int findMin(int[] nums) {
            return nums[findMin(nums, 0, nums.length-1)];
        }
        
        public int findMin(int[] nums, int l, int r) {
            if (l == r) return l;
            int mid = (l+r)/2;
            if (nums[mid] > nums[r]) {
                // 向右找
                return findMin(nums, mid+1, r);
            } else {
                // 向左找
                return findMin(nums, l, mid);
            }
        }
        
    }
    
    public static void main(String[] args) {
        int[] nums = { 11, 13, 16, 18, 5, 7, 9 };
        int r = new Solution().findMin(nums);
        Out.p(r);
    }

}
