package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Next Permutation
 *
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * The replacement must be in-place and use only constant extra memory.
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * Example:
 *      
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/next-permutation/
 * @since   2020-02-26 19:23:49
 */
public class L0031_Next_Permutation {
    /**
     * 字典序算法
     */
    static class Solution {
        public void nextPermutation(int[] nums) {
            if (nums.length < 2) return;
            // 1. 寻找 k
            int k = -1;
            for (int i = nums.length - 2; i >= 0; i--) {
                if (nums[i] < nums[i+1]) {
                    k = i;
                    break;
                }
            }

            if (k == -1) {
                reverse(nums, 0, nums.length-1);
                return;
            }

            // 2. 寻找 l,从右侧找到第一个大于 nums[l] > nums[k] 的 l
            int l = -1;
            for (int i = nums.length-1; i > k; i--) {
                if (nums[i] > nums[k]) {
                    l = i;
                    break;
                }
            }

            // 3. 交换 nums[k] nums[l]
            swap(nums, k, l);

            // 4. 翻转 nums[k+1..n]
            reverse(nums, k+1, nums.length-1);

        }

        private void reverse(int[] nums , int s, int t) {
            for (int i = 0; i < (t-s+1)/2; i++) swap(nums, s+i, t-i);
        }

        private void swap(int[] nums, int i, int j) {
            if (i == j) return;
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
