package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Palindrome Number
 *
 * Determine whether an integer is a palindrome. An integer&nbsp;is&nbsp;a&nbsp;palindrome when it&nbsp;reads the same backward as forward.
 *
 * Example:
 *      Example 1
 *      Input: 121
 *      Output: true
 *      Example 2
 *      Input: -121
 *      Output: false
 *      Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 *      Example 3
 *      Input: 10
 *      Output: false
 *      Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 *      Follow up:
 *      Coud you solve&nbsp;it without converting the integer to a string?
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/palindrome-number/
 * @since   2020-02-23 20:33:11
 */
public class L0009_Palindrome_Number {
    /**
     * 构建获取某一位数字的方法，然后首尾比较
     */
    static class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0) {
                return false;
            }
            int l = 0;
            for (int t = x; t != 0; t /= 10) {
                l ++;
            }
            for (int i = 0; i < l / 2; i++) {
                if (getSingle(x, i) != getSingle(x, l-i-1)) {
                    return false;
                }
            }
            return true;
        }

        private int getSingle(int x, int idx) {
            return ((int)(x / Math.pow(10, idx)) % 10);
        }
    }
    
    public static void main(String[] args) {
        int x = 1221;
        Out.p(new Solution().isPalindrome(x));
    }
}
