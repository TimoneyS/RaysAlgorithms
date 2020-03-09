package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Number of Digit One
 * -----------------------------------------------------------------------------
 * Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.
 *
 * Example:
 *      Example 1
 *      Input: 13
 *      Output: 6 
 *      Explanation: Digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/number-of-digit-one/
 * @since   2020-03-09 21:37:15
 */
public class L0233_Number_of_Digit_One {
    /**
     * 对于小于n的每个数字，如果其数字中有1，这个1会在 开头，也可能在中间
     * 那么根据两种情况，计算开始的 1 ，计算身体中的 1
     * 比如任意一个数字 3241
     *
     * 这些数字可以分类：
     *      a     0 ~  999  身体中有 1
     *      b  1000 ~ 1999  身体中有 1，开头为 1
     *      c  2000 ~ 2999  身体中有 1
     *      d  3000 ~ 3241  身体中有 1
     * 显然，数字开头的1，有1000个，实际上就是 1 后面可能的数字数量
     * 重点在于数字身体中的 1，假设 0 ~ 999 中共有 m 个 1 ，那么 1000 ~ 1999 出去开头的 1 ， 2000 ~ 2999 中的 1 一定也都是 m 个
     * 3000 ~ 3241 中的 1 和 0 ~ 241 中的 1 的数量也一定一致
     *
     * 所以可以分解 dp(3241) = numbers(1000, 1999) + 3 * dp(999) + dp(241) = 10^k + 3 * dp(999) + dp(241)
     *
     * 需要注意，数字本身就是 1 开始的情况，如 1251
     * 数字可以分类
     *       0 ~ 999 身体中有 1
     *    1000 ~ 1251 开头为 1， 身体中也有 1
     * 1000 ~ 1251 中开头的1的数量，就是 1000 ~ 1251 的数字的个数，身体中的1 的数量就是 0 ~ 251 中 1 的数量
     * dp(1251) = numbers(1000, 251) + dp(999) + dp(251)
     */
    static class Solution {
        public int countDigitOne(int n) {
            return c(n);
        }

        int c(int n) {
            if (n < 1) return 0;
            if (n < 10) return 1;
            int rate = 1;
            for (int i = n/100; i > 0; i /= 10) rate *= 10;
            if (n >= 20 * rate) {
                return rate*10 + c(n - n/rate/10*rate*10) + n/rate/10 * c(rate*10-1);
            } else {
                return (n - rate * 10 + 1) + c(n - n/rate/10*rate*10) + c(rate*10-1);
            }
        }

    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
