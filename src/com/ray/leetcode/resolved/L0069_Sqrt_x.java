package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Sqrt(x)
 *
 * Implement int sqrt(int x).
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
 *
 * Example:
 *      Example 1
 *      Input: 4
 *      Output: 2
 *      Example 2
 *      Input: 8
 *      Output: 2
 *      Explanation: The square root of 8 is 2.82842..., and since 
 *                   the decimal part is truncated, 2 is returned.
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/sqrtx/
 * @since   2020-02-28 22:53:48
 */
public class L0069_Sqrt_x {
    static class Solution {
        public int mySqrt(int x) {
            long l = 1, r = x;
            while (l + 1 < r) {
                long mid = l + (r - l) / 2;
                if (mid * mid == (long) x) {
                    return (int) mid;
                } else if (mid * mid < (long) x) {
                    l = mid;
                } else {
                    r = mid;
                }
            }
            if (r * r == (long) x) return (int) r;
            return (int) l;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
