package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Find Minimum in Rotated Sorted Array II
 * -----------------------------------------------------------------------------
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 * Find the minimum element.
 * The array may contain duplicates.
 *
 * Example:
 *      Example 1
 *      Input: [1,3,5]
 *      Output: 1
 *      Example 2
 *      Input: [2,2,2,0,1]
 *      Output: 0
 *      Note:
 *      	This is a follow up problem to Find Minimum in Rotated Sorted Array.
 *      	Would allow duplicates affect the run-time complexity? How and why?
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
 * @since   2020-03-07 21:29:04
 */
public class L0154_Find_Minimum_in_Rotated_Sorted_Array_II {
    static class Solution {

        public int findMin(int[] nums) {
            return nums[findMin(nums, 0, nums.length-1)];
        }

        public int findMin(int[] nums, int l, int r) {
            if (nums[l] < nums[r] || l == r) return l;
            int mid = (l+r)/2;
            if (nums[mid] > nums[r]) {
                // 向右找
                return findMin(nums, mid+1, r);
            } else if (nums[mid] < nums[r]) {
                return findMin(nums, l, mid);
            } else {
                // 向左找
                int i = findMin(nums, l, mid);
                int j = findMin(nums, mid+1, r);
                if (nums[i] < nums[j])
                    return i;
                else
                    return j;
            }
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
