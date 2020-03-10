package com.ray.leetcode.resolved;

/**
 * Range Sum Query - Mutable
 * -----------------------------------------------------------------------------
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * The update(i, val) function modifies nums by updating the element at index i to val.
 *
 * Example:
 *      Example 1
 *      Given nums = [1, 3, 5]
 *      sumRange(0, 2) -> 9
 *      update(1, 2)
 *      sumRange(0, 2) -> 8
 *      Note:
 *      	The array is only modifiable by the update function.
 *      	You may assume the number of calls to update and sumRange function is distributed evenly.
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/range-sum-query-mutable/
 * @since   2020-03-11 00:02:21
 */
public class L0307_Range_Sum_Query___Mutable {
    static class NumArray {

        int[] sumOf;

        public NumArray(int[] nums) {
            if (nums.length > 0) {
                sumOf = new int[nums.length];
                sumOf[0] = nums.length <= 0 ? 0 : nums[0];
                for (int i = 1; i < nums.length; i++)
                    sumOf[i] = sumOf[i - 1] + nums[i];
            }
        }

        public void update(int i, int val) {
            if (sumOf == null) return;
            int diff = val - sumRange(i, i);
            for (int j = i; j < sumOf.length; j++ ) {
                sumOf[j] += diff;
            }
        }

        public int sumRange(int i, int j) {
            return sumOf == null ? 0 : sumOf[j] - (i > 0 ? sumOf[i-1] : 0);
        }
    }
    
    public static void main(String[] args) {
    }
}
