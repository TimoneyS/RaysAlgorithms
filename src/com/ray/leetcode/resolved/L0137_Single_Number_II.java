package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.Arrays;

/**
 * Single Number II
 * -----------------------------------------------------------------------------
 * Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Example:
 *      Example 1
 *      Input: [2,2,3,2]
 *      Output: 3
 *      Example 2
 *      Input: [0,1,0,1,0,1,99]
 *      Output: 99
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/single-number-ii/
 * @since   2020-03-05 23:14:49
 */
public class L0137_Single_Number_II {
    /**
     * 改造二进制的异或操作
     *  0 ^ 1 = 1
     *  1 ^ 1 = 2
     *  2 ^ 1 = 0
     */
    static class Solution {
        public int singleNumber(int[] A) {
            int[] nums = new int[32];
            Arrays.stream(A).forEach(i -> xor(nums, i));
            int n = 0;
            for (int i = 0; i < nums.length; i++) {
                n |= (nums[i] << i);
            }
            return n;
        }

        void xor(int[] nums, int n) {
            for (int i = 0; i < 32; i++) {
                if ((n & (1 << i)) == (1 << i)) {
                    nums [i] ++;
                    nums[i] %= 3;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        int[] A = {-2,-2,-1,-1,-3, -1,-3,-3,-4,-2};
        Out.p(new Solution().singleNumber(A));
    }
}
