package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Single Number
 * -----------------------------------------------------------------------------
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Example:
 *      Example 1
 *      Input: [2,2,1]
 *      Output: 1
 *      Example 2
 *      Input: [4,1,2,1,2]
 *      Output: 4
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/single-number/
 * @since   2020-03-05 23:14:06
 */
public class L0136_Single_Number {
    /**
     * a ^ a ^ b = b
     */
    static class Solution {
        public int singleNumber(int[] A) {
            int num = 0;
            for (int i : A) num = num ^ i;
            return num;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
