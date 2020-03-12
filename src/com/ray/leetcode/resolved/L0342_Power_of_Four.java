package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Power of Four
 * -----------------------------------------------------------------------------
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 *
 * Example:
 *      Example 1
 *      Input: 16
 *      Output: true
 *      Example 2
 *      Input: 5
 *      Output: false
 *      Follow up: Could you solve it without loops/recursion?
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/power-of-four/
 * @since   2020-03-12 22:45:20
 */
public class L0342_Power_of_Four {
    static class Solution {
        public boolean isPowerOfFour(int num) {
            if (num == 0) return false;
            int n = (int)Math.sqrt(num);
            return n*n == num && (n & (n-1)) == 0;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
