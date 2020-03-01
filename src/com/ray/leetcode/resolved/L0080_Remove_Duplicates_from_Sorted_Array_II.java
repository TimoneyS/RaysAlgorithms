package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Remove Duplicates from Sorted Array II
 *
 * Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Example:
 *      Example 1
 *      Given nums = [1,1,1,2,2,3],
 *      Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
 *      It doesn't matter what you leave beyond the returned length.
 *      Example 2
 *      Given nums = [0,0,1,1,1,1,2,3,3],
 *      Your function should return length = 7, with the first seven elements of nums being modified to 0, 0, 1, 1, 2, 3 and 3 respectively.
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
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
 * @since   2020-02-29 23:17:59
 */
public class L0080_Remove_Duplicates_from_Sorted_Array_II {
    /**
     * 当遍历到一个元素时
     *      如果这个元素和前一个元素不同，那一定是新的元素，直接加入新的数组
     *      如果这个元素和前一个元素相同，那检查这个元素是否已经加入新的数组两次，是则不处理，否则加入
     *      也可以统计这个元素出现的次数，如果超过2则不加入
     */
    static class Solution {
        public int removeDuplicates(int[] nums) {
            int cursor = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i == 0 || nums[i] != nums[i-1]) {
                    nums[cursor++] = nums[i];
                } else if (nums[i] == nums[i-1]) {
                    if (cursor < 2 || nums[i] != nums[cursor-2]) {
                        nums[cursor++] = nums[i];
                    }
                }
            }
            return cursor;
        }
    }

    class Solution2 {
        public int removeDuplicates(int[] nums) {
            int cursor = 0;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i != 0 && nums[i] != nums[i-1]) {
                    count = 1;
                } else {
                    count ++;
                }
                if (count <= 2) {
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
