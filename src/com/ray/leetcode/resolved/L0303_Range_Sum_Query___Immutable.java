package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Range Sum Query - Immutable
 * -----------------------------------------------------------------------------
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 *
 * Example:
 *      Example 1
 *      Given nums = [-2, 0, 3, -5, 2, -1]
 *      sumRange(0, 2) -> 1
 *      sumRange(2, 5) -> -1
 *      sumRange(0, 5) -> -3
 *      Note:
 *      You may assume that the array does not change.
 *      There are many calls to sumRange function.
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/range-sum-query-immutable/
 * @since   2020-03-11 00:04:46
 */
public class L0303_Range_Sum_Query___Immutable {
    /**
     * 数组区间和等于数组阶段和相减。
     */
    static class NumArray {

        int[] S ;

        public NumArray(int[] nums) {
            S = new int[nums.length+1];
            for (int i = 1; i < S.length; i++) {
                S[i] = S[i-1] + nums[i-1];
            }
        }

        public int sumRange(int i, int j) {
            return S[j+1] - S[i];
        }
    }
    
    public static void main(String[] args) {
    }
}
