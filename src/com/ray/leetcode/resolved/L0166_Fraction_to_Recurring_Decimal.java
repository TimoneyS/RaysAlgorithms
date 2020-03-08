package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.HashMap;
import java.util.Map;

/**
 * Fraction to Recurring Decimal
 * -----------------------------------------------------------------------------
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 *
 * Example:
 *      Example 1
 *      Input: numerator = 1, denominator = 2
 *      Output: 0.5
 *      Example 2
 *      Input: numerator = 2, denominator = 1
 *      Output: 2
 *      Example 3
 *      Input: numerator = 2, denominator = 3
 *      Output: 0.(6)
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/fraction-to-recurring-decimal/
 * @since   2020-03-07 23:37:07
 */
public class L0166_Fraction_to_Recurring_Decimal {
    /**
     * a       / b = c1 .. d1
     * d1 * 10 / b = c2 .. d2
     * d2 * 10 / b = c3 .. d3
     *
     * 出发的过程就是不断的除，并求余数，然后用余数再除。
     * 用循环就能够模拟这种过程。
     *
     * 在小数位，需要关注循环点。循环出现的标志就是一个余数，第二次出现，那么后续的除法结果和第一次出现必然一致。
     * 因此在小数计算部分，用map记录每个余数出现的位置，一个循环第一次和第二次出现之间的部分就是循环部分。
     */
    static class Solution {
        public String fractionToDecimal(int numerator, int denominator) {
            if (numerator == 0) return "0";
            if (numerator < 0 && denominator < 0) {
                return comp(-(long)numerator, -(long)denominator);
            } else if (numerator < 0 || denominator < 0) {
                return "-" + comp(Math.abs((long)numerator), Math.abs((long)denominator));
            }
            return comp(numerator, denominator);
        }

        String comp(long a, long b) {
            StringBuilder rs = new StringBuilder();
            while (a >= b) {
                rs.append(a / b);
                a %= b;
            }
            if (rs.length() == 0) {
                rs.append('0');
            }
            if (a != 0) {
                rs.append('.');
            }
            Map<Long, Integer> map = new HashMap<>();
            while (a != 0) {
                if (map.containsKey(a)) {
                    int l = map.get(a);
                    rs.insert(l, '(');
                    rs.append(')');
                    break;
                }
                map.put(a, rs.length());
                while (a * 10 < b) {
                    a = a * 10;
                    rs.append('0');
                }
                a = a * 10;
                rs.append(a / b);
                a %= b;
            }
            return rs.toString();
        }
    }

    public static void main(String[] args) {
        int i = 1;
        int j = 2;
        Out.p(new Solution().fractionToDecimal(i, j));
    }
}
