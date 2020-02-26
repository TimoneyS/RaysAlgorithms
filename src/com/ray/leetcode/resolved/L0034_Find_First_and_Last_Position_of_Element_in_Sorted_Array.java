package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.Arrays;

/**
 * Find First and Last Position of Element in Sorted Array
 *
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 *
 * Example:
 *      Example 1
 *      Input: nums = [5,7,7,8,8,10], target = 8
 *      Output: [3,4]
 *      Example 2
 *      Input: nums = [5,7,7,8,8,10], target = 6
 *      Output: [-1,-1]
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * @since   2020-02-26 19:27:37
 */
public class L0034_Find_First_and_Last_Position_of_Element_in_Sorted_Array {
    static class Solution {
        public int[] searchRange(int[] nums, int target) {
            int l = Arrays.binarySearch(nums, target);
            int r = l;
            int t = l;

            if (l < 0) {
                return new int[] {-1, -1};
            }
            while (t > 0 && (t = Arrays.binarySearch(nums, 0, t, target)) >= 0) {
                l = t;
            }
            t = r;
            while (t+1 < nums.length && (t = Arrays.binarySearch(nums, t + 1, nums.length, target)) >= 0) {
                r = t;
            }
            return new int[] {l, r};
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
