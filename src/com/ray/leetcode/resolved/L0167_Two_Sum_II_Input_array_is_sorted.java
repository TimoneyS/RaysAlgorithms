package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.Arrays;

/**
 * Two Sum II - Input array is sorted
 * -----------------------------------------------------------------------------
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
 * Note:
 * 	Your returned answers (both index1 and index2) are not zero-based.
 * 	You may assume that each input would have exactly one solution and you may not use the same element twice.
 *
 * Example:
 *      Example 1
 *      Input: numbers = [2,7,11,15], target = 9
 *      Output: [1,2]
 *      Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 * @since   2020-03-08 10:37:06
 */
public class L0167_Two_Sum_II_Input_array_is_sorted {
    /**
     * 对每个数字在后续的数字中寻找是否存在 value - num
     * 因为数组有序，因此后续的查询可以使用二分搜索
     *
     * 复杂度为 {log n + log n-1 + ... + log 1} = O(log n!)
     */
    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            int index1 = 0, index2 = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                int rs = Arrays.binarySearch(nums, i + 1, nums.length, target - nums[i]);
                if (rs > 0) {
                    index1 = i + 1;
                    index2 = rs + 1;
                    break;
                }
            }
            if (index1 * index2 != 0)
                return new int[] {index1, index2};
            return new int[] {};
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
