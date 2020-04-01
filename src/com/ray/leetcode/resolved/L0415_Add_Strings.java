package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Add Strings
 * -----------------------------------------------------------------------------
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 * Note:
 * The length of both num1 and num2 is 
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 *
 * Example:
 *      
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/add-strings/
 * @since   2020-03-31 22:19:54
 */
public class L0415_Add_Strings {
    static class Solution {
        public String addStrings(String num1, String num2) {
            char[] chars = new char[Math.max(num1.length(), num2.length()) + 1];
            int cursor = chars.length;
            int prev = 0, deviation = '0' * 2;

            for (int i1 = num1.length()-1, i2 = num2.length()-1; i1 >= 0 || i2 >= 0; i1 --, i2 --) {
                char c1 = i1 >= 0 ? num1.charAt(i1) : '0';
                char c2 = i2 >= 0 ? num2.charAt(i2) : '0';

                int sum = c1 + c2 + prev - deviation;
                chars[--cursor] = (char) (sum % 10 + '0');
                prev = sum / 10;
            }
            if (prev > 0)
                chars[--cursor] = (char) (prev + '0');
            return new String(chars, cursor, chars.length - cursor);
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
