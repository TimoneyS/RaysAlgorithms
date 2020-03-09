package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.Arrays;

/**
 * Ugly Number
 * -----------------------------------------------------------------------------
 * Write a program to check whether a given number is an ugly number.
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 *
 * Example:
 *      Example 1
 *      Input: 6
 *      Output: true
 *      Explanation: 6 = 2 &times; 3
 *      Example 2
 *      Input: 8
 *      Output: true
 *      Explanation: 8 = 2 &times; 2 &times; 2
 *      Example 3
 *      Input: 14
 *      Output: false 
 *      Explanation: 14 is not ugly since it includes another prime factor 7.
 *      Note:
 *      	1 is typically treated as an ugly number.
 *      	Input is within the 32-bit signed integer range: [&minus;231,  231 &minus; 1].
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/ugly-number/
 * @since   2020-03-09 21:50:17
 */
public class L0263_Ugly_Number {
    static class Solution {
        public boolean isUgly(int num) {
            if (num == 0) return false;
            int[] factors = {2, 3, 5};
            for (int factor : factors)
                while (num % factor == 0)
                    num /= factor;
            return Arrays.binarySearch(factors, num) >= 0 || num == 1;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
