package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.Stack;

/**
 * Shuffle an Array
 * -----------------------------------------------------------------------------
 * Shuffle a set of numbers without duplicates.
 *
 * Example:
 *      Example 1
 *      // Init an array with set 1, 2, and 3.
 *      int[] nums = {1,2,3};
 *      Solution solution = new Solution(nums);
 *      // Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
 *      solution.shuffle();
 *      // Resets the array back to its original configuration [1,2,3].
 *      solution.reset();
 *      // Returns the random shuffling of array [1,2,3].
 *      solution.shuffle();
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/shuffle-an-array/
 * @since   2020-03-23 21:56:27
 */
public class L0384_Shuffle_an_Array {
    static class Solution {

        Stack<int[]> stack = new Stack<>();
        int[] inner;

        public Solution(int[] nums) {
            inner = nums;
        }

        public int[] reset() {
            while (!stack.empty())  {
                int[] s = stack.pop();
                swap(s[0], s[1]);
            }
            return inner;
        }

        public int[] shuffle() {
            for (int i = 0; i < inner.length;i ++) {
                int j = (int) (Math.random() * (inner.length - i) + i);
                swap(i, j);
                stack.push(new int[]{i, j});
            }
            return inner;
        }

        void swap(int i, int j) {
            int t = inner[i];
            inner[i] = inner[j];
            inner[j] = t;
        }
    }

    public static void main(String[] args) {
    }
}
