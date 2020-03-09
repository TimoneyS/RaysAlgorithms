package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Power of Two
 * -----------------------------------------------------------------------------
 * Given an integer, write a function to determine if it is a power of two.
 *
 * Example:
 *      Example 1
 *      Input: 1
 *      Output: true 
 *      Explanation: 20 = 1
 *      Example 2
 *      Input: 16
 *      Output: true
 *      Explanation: 24 = 16
 *      Example 3
 *      Input: 218
 *      Output: false
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/power-of-two/
 * @since   2020-03-09 21:34:22
 */
public class L0231_Power_of_Two {
    static class Solution {
        public boolean isPowerOfTwo(int n) {
            return (n > 0) && (n & (n - 1)) == 0;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
