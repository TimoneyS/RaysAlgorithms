package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Valid Perfect Square
 * -----------------------------------------------------------------------------
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 * Note: Do not use any built-in library function such as sqrt.
 *
 * Example:
 *      Example 1
 *      Input: 16
 *      Output: true
 *      Example 2
 *      Input: 14
 *      Output: false
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/valid-perfect-square/
 * @since   2020-03-17 22:47:50
 */
public class L0367_Valid_Perfect_Square {
    /**
     * 二分搜索
     */
    static class Solution {
        public boolean isPerfectSquare(int num) {
            return isPerfectSquare(num, 1, num);
        }

        private boolean isPerfectSquare(int num, int i, int j) {
            if (i > j) return false;
            int m = (i + j) / 2;
            if ( m * m == num) return true;
            if (num / m >= m) {
                return isPerfectSquare(num, m+1, j);
            } else {
                return isPerfectSquare(num, i, m - 1);
            }
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
