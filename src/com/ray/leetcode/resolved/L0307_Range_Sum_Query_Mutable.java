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
public class L0307_Range_Sum_Query_Mutable {
    // 树状数组
    static class NumArray {
        int[] inner, arr;

        public NumArray(int[] nums) {
            arr = nums;
            inner = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++)
                add(i, nums[i]);

        }

        public void update(int i, int val) {
            add(i, val - arr[i]);
            arr[i] = val;
        }

        private void add(int i, int val) {
            i += 1;
            while (i < inner.length) {
                inner[i] += val;
                i += i & -i;
            }
        }

        public int sumRange(int i, int j) {
            return sum(j) - sum(i-1);
        }

        private int sum(int i) {
            int sum = 0;
            i ++;
            while (i != 0) {
                sum += inner[i];
                i -= i & -i;
            }
            return sum;
        }
    }
    
    public static void main(String[] args) {
    }
}
