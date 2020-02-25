package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Remove Duplicates from Sorted Array
 *
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Example:
 *      Example 1
 *      Given nums = [1,1,2],
 *      Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 *      It doesn't matter what you leave beyond the returned length.
 *      Example 2
 *      Given nums = [0,0,1,1,1,2,2,3,3,4],
 *      Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.
 *      It doesn't matter what values are set beyond the returned length.
 *      Clarification:
 *      Confused why the returned value is an integer but your answer is an array?
 *      Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.
 *      Internally you can think of this:
 *      // nums is passed in by reference. (i.e., without making a copy)
 *      int len = removeDuplicates(nums);
 *      // any modification to nums in your function would be known by the caller.
 *      // using the length returned by your function, it prints the first len elements.
 *      for (int i = 0; i &lt; len; i++) {
 *          print(nums[i]);
 *      }
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * @since   2020-02-25 20:42:38
 */
public class L0026_Remove_Duplicates_from_Sorted_Array {
    /**
     * 排序数组
     * 用两个指针遍历数组，快的指针遍历所有元素，慢的指针指向唯一元素。
     */
    static class Solution {
        public int removeDuplicates(int[] nums) {
            int cursor = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i == 0 || nums[i] != nums[i-1]) {
                    nums[cursor++] = nums[i];
                }
            }
            return cursor;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
