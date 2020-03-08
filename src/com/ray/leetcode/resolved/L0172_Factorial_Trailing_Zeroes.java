package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Factorial Trailing Zeroes
 * -----------------------------------------------------------------------------
 * Given an integer n, return the number of trailing zeroes in n!.
 *
 * Example:
 *      Example 1
 *      Input: 3
 *      Output: 0
 *      Explanation: 3! = 6, no trailing zero.
 *      Example 2
 *      Input: 5
 *      Output: 1
 *      Explanation: 5! = 120, one trailing zero.
 *      Note: Your solution should be in logarithmic time complexity.
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/factorial-trailing-zeroes/
 * @since   2020-03-08 17:39:13
 */
public class L0172_Factorial_Trailing_Zeroes {
    /**
     * 尾部的 0 来源是 5 和偶数相乘，而 10， 100 等这样的情况也可以表示成 5 和偶数相乘。
     * 因此问题可以转化为阶乘的数字可以转化出多少个5相乘。
     */
    static class Solution {
        public int trailingZeroes(int n) {
            int sum = 0;
            while (n != 0) {
                sum += n / 5;
                n /= 5;
            }
            return sum;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
