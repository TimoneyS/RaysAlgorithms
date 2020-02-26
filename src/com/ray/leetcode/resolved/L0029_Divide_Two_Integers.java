package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Divide Two Integers
 *
 * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
 * Return the quotient after dividing dividend by divisor.
 * The integer division should truncate toward zero.
 *
 * Example:
 *      Example 1
 *      Input: dividend = 10, divisor = 3
 *      Output: 3
 *      Example 2
 *      Input: dividend = 7, divisor = -3
 *      Output: -2
 *      Note:
 *      	Both dividend and divisor will be 32-bit signed integers.
 *      	The divisor will never be 0.
 *      	Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [&minus;231,  231 &minus; 1]. For the purpose of this problem, assume that your function returns 231 &minus; 1 when the division result overflows.
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/divide-two-integers/
 * @since   2020-02-26 19:11:12
 */
public class L0029_Divide_Two_Integers {
    /**
     * 计算 a 除以 b 的步骤如下
     *
     * 首先利用位操作，确定      b*2^i  < a < b*2^i+1
     *      a = b*2^i + k
     *        = b*2^i + n*b
     *    a/b = 2^i + n
     * n = ( a - b * 2 ^ i) / b
     *
     * 因此问题从  a / b 演变为 ( a - b * 2 ^ i) / b
     * 不断重复以上过程，直到 ( a - b * 2 ^ i) < b 时结束计算
     */
    static class Solution {
        public int divide(int dividend, int divisor) {
            if (divisor == 0) return dividend >= 0? Integer.MAX_VALUE : Integer.MIN_VALUE;
            if (dividend == 0) return 0;
            if (dividend == Integer.MIN_VALUE && divisor == -1)  return Integer.MAX_VALUE;
            boolean flag = (dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0);
            long a = Math.abs((long)dividend);
            long b = Math.abs((long)divisor);
            int result = 0;
            while(a >= b){
                int shift = 0;
                while(a >= (b << shift)){
                    shift++;
                }
                a -= b << (shift - 1);
                result += 1 << (shift - 1);
            }
            return (int) (flag ? result : -result);
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
