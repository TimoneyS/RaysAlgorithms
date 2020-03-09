package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Missing Number
 * -----------------------------------------------------------------------------
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 *
 * Example:
 *      Example 1
 *      Input: [3,0,1]
 *      Output: 2
 *      Example 2
 *      Input: [9,6,4,2,3,5,7,0,1]
 *      Output: 8
 *      Note:
 *      Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/missing-number/
 * @since   2020-03-09 23:33:18
 */
public class L0268_Missing_Number {
    /**
     * 题目的关键在于发现，这个数组中有 0 ~ n 的所有数字中的 n 个
     * 如果这些数字顺序排列，必然有  nums[i] = i 然后某个点之后是 nums[i] = i+1
     *              -------------------------------
     *               0 1 2 3 ... i-1 i+1 ......n     数字
     *              -------------------------------
     *               0 1 2 3 ....i-1 i .......n-1    坐标
     *  如果将所有的数字 i 都放到 nuns[i-1] 的位置
     *              -------------------------------
     *               1 2 3 4 ... -  i+1 ......n     数字
     *              -------------------------------
     *               0 1 2 3 ....i-1 i .......n-1    坐标
     *
     *  最终 i - 1 的位置会无法填充，这个无法被填充的位置，就是缺失的位置
     *  因此，遍历数组，将遇到的每个数字都放到对应的位置，不断交换
     *  最终检查那个没有合适数字的位置即可
     */
    static class Solution {
        public int missingNumber(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0 || nums[i] == i+1) continue;
                while (nums[i] > 0 && nums[i] != i+1) {
                    int temp = nums[nums[i]-1];
                    nums[nums[i]-1] = nums[i];
                    nums[i] = temp;
                }
            }
            for (int i = 0; i < nums.length; i++)
                if (nums[i] != i+1) return i+1;
            return 0;
        }
    }
    
    public static void main(String[] args) {
        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        Out.p(new Solution().missingNumber(nums));
    }
}
