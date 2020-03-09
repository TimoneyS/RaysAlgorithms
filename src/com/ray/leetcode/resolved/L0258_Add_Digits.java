package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Add Digits
 * -----------------------------------------------------------------------------
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 *
 * Example:
 *      Example 1
 *      Input: 38
 *      Output: 2 
 *      Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2. 
 *                   Since 2 has only one digit, return it.
 *      Follow up:
 *      Could you do it without any loop/recursion in O(1) runtime?
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/add-digits/
 * @since   2020-03-09 21:47:27
 */
public class L0258_Add_Digits {
    static class Solution {
        public int addDigits(int num) {
            int t = 0;
            while (num > 0) {
                if (num < 10) {
                    num += t;
                    t = 0;
                    if (num < 10) break;
                } else {
                    t += num %10;
                    num /= 10;
                }
            }
            return num;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
