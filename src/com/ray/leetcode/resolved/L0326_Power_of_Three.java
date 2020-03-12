package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Power of Three
 * -----------------------------------------------------------------------------
 * Given an integer, write a function to determine if it is a power of three.
 *
 * Example:
 *      Example 1
 *      Input: 27
 *      Output: true
 *      Example 2
 *      Input: 0
 *      Output: false
 *      Example 3
 *      Input: 9
 *      Output: true
 *      Example 4
 *      Input: 45
 *      Output: false
 *      Follow up:
 *      Could you do it without using any loop / recursion?
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/power-of-three/
 * @since   2020-03-12 22:45:45
 */
public class L0326_Power_of_Three {
    static class Solution {
        public boolean isPowerOfThree(int n) {
            return n > 0 && 1162261467%n == 0;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
