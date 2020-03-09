package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Product of Array Except Self
 * -----------------------------------------------------------------------------
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 *
 * Example:
 *      Example 1
 *      Input:  [1,2,3,4]
 *      Output: [24,12,8,6]
 *      Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.
 *      Note: Please solve it without division and in O(n).
 *      Follow up:
 *      Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/product-of-array-except-self/
 * @since   2020-03-09 21:41:18
 */
public class L0238_Product_of_Array_Except_Self {
    /**
     * 从左侧计算从 0 到 i   的乘积 SL[i]
     * 从右侧计算从 i 到 n-1 的乘积 SR[i]
     *
     * B[i] = SL[i-1] * SR[i+1]
     */
    static class Solution {
        public int[] productExceptSelf(int[] nums) {
            if (nums.length == 1) return new int[] {1};
            int N = nums.length;
            long[] SL = new long[N];
            long[] SR = new long[N];
            SL[0]   = nums[0];
            SR[N-1] = nums[N - 1];
            for (int i = 1; i < N; i++) {
                SL[i] = SL[i-1] * nums[i];
                SR[N-1-i] = SR[N-i] * nums[N-1-i];
            }
            int[] B = new int[N];
            B[0] = (int) SR[1];
            B[N-1] = (int) SL[N-2];
            for (int i = 1; i < N-1; i++) {
                B[i] = (int) (SL[i-1] * SR[i+1]);
            }
            return B;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
