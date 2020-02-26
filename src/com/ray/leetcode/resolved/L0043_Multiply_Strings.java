package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.Arrays;

/**
 * Multiply Strings
 *
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
 *
 * Example:
 *      Example 1
 *      Input: num1 = 2, num2 = 3
 *      Output: 6
 *      Example 2
 *      Input: num1 = 123, num2 = 456
 *      Output: 56088
 *      Note:
 *      	The length of both num1 and num2 is &lt; 110.
 *      	Both num1 and num2 contain only digits 0-9.
 *      	Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 *      	You must not use any built-in BigInteger library or convert the inputs to integer directly.
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/multiply-strings/
 * @since   2020-02-26 23:04:31
 */
public class L0043_Multiply_Strings {
    static class Solution {
        public String multiply(String num1, String num2) {
            int[] rs = new int[num1.length()+num2.length()+2];
            for (int i = num1.length()-1; i >= 0; i --) {
                int deviation = rs.length - num1.length() + i;
                for (int j = num2.length()-1; j >= 0; j--) {
                    add(rs,   deviation, (num1.charAt(i) - '0') * (num2.charAt(j) - '0'));
                    deviation--;
                }
            }
            StringBuilder sb = new StringBuilder();
            int start = -1;
            while (start < rs.length-1) if (rs[++start] > 0) break;
            for (int i = start; i < rs.length; i++)
                sb.append(rs[i]);
            return sb.toString();
        }

        private void add(int[] rs, int deviation, int num) {
            int prev = num;
            for (int i = deviation; i >= 0; i--) {
                rs[i] += prev;
                if (rs[i] < 10) break;
                prev = rs[i] / 10;
                rs[i] = rs[i] % 10;
            }
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
