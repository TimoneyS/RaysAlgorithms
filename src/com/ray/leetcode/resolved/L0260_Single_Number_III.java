package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Single Number III
 * -----------------------------------------------------------------------------
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.
 *
 * Example:
 *      Example 1
 *      Input:  [1,2,1,3,2,5]
 *      Output: [3,5]
 *      Note:
 *      	The order of the result is not important. So in the above example, [5, 3] is also correct.
 *      	Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/single-number-iii/
 * @since   2020-03-09 21:48:27
 */
public class L0260_Single_Number_III {
    /**
     * 从 a ^ b 中分离 a 和 b
     * a 和 b 一定在某个二进制位上不同，那么按照这个不同
     * 进行两个异或的算法
     */
    static class Solution {
        public int[] singleNumber(int[] A) {
            int xor = 0;
            for (int n : A) xor ^= n;
            int lastBit = xor - (xor & (xor-1));
            int n1 = 0, n2 = 0;
            for (int n : A) {
                if ((lastBit & n) == 0) {
                    n1 ^= n;
                } else {
                    n2 ^= n;
                }
            }
            return new int[]{n1, n2};
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
