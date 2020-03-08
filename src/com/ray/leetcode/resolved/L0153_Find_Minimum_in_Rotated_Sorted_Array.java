package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Find Minimum in Rotated Sorted Array
 * -----------------------------------------------------------------------------
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 * Find the minimum element.
 * You may assume no duplicate exists in the array.
 *
 * Example:
 *      Example 1
 *      Input: [3,4,5,1,2] 
 *      Output: 1
 *      Example 2
 *      Input: [4,5,6,7,0,1,2]
 *      Output: 0
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 * @since   2020-03-07 21:28:18
 */
public class L0153_Find_Minimum_in_Rotated_Sorted_Array {
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
        Out.p(new Solution());
    }
}
