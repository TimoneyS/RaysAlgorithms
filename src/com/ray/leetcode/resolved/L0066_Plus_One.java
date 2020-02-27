package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Plus One
 *
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *      Example 1
 *      Input: [1,2,3]
 *      Output: [1,2,4]
 *      Explanation: The array represents the integer 123.
 *      Example 2
 *      Input: [4,3,2,1]
 *      Output: [4,3,2,2]
 *      Explanation: The array represents the integer 4321.
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/plus-one/
 * @since   2020-02-27 23:16:33
 */
public class L0066_Plus_One {
    static class Solution {
        public int[] plusOne(int[] digits) {

            int post = 1;
            for (int i = digits.length - 1; i >= 0; i--) {
                if (digits[i] + 1 < 10) {
                    digits[i] ++;
                    post = 0;
                } else {
                    digits[i] = 0;
                }
                if (post == 0) break;
            }

            if (post == 1) {
                int[] newNum = new int[digits.length + 1];
                newNum[0] = 1;
                System.arraycopy(digits, 0, newNum, 1, newNum.length - 1);
                return newNum;
            }
            return digits;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
