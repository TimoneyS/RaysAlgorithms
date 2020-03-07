package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Valid Palindrome
 * -----------------------------------------------------------------------------
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 *
 * Example:
 *      Example 1
 *      Input: A man, a plan, a canal: Panama
 *      Output: true
 *      Example 2
 *      Input: race a car
 *      Output: false
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/valid-palindrome/
 * @since   2020-03-04 22:36:49
 */
public class L0125_Valid_Palindrome {
    /**
     * 双指针法，左右并进，掠过非字母和数字，分别比较遇到的第一个符合要求的字符。
     */
    static class Solution {

        public boolean isPalindrome(String s) {
            int l = 0, r = s.length() -1;
            while (l < r) {
                while (l < s.length() && !isCheck(s.charAt(l))) l ++;
                while (r >= 0         && !isCheck(s.charAt(r))) r --;
                if (l < r && !isMatch(s.charAt(r--), s.charAt(l++))) {
                    return false;
                }
            }
            return true;
        }

        boolean isCheck(char c) {
            return c >= '0' && c <= '9' || c >= 'A' && c < 'Z' || c >= 'a' && c < 'z';
        }

        boolean isMatch(char c1, char c2) {
            if (c1 >= 'A' && c1 < 'Z') c1 = (char) (c1 - 'A' + 'a');
            if (c2 >= 'A' && c2 < 'Z') c2 = (char) (c2 - 'A' + 'a');
            return c1 == c2;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
