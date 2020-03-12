package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Reverse String
 * -----------------------------------------------------------------------------
 * Write a function that reverses a string. The input string is given as an array of characters char[].
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * You may assume all the characters consist of printable ascii characters.
 *
 * Example:
 *      Example 1
 *      Input: [h,e,l,l,o]
 *      Output: [o,l,l,e,h]
 *      Example 2
 *      Input: [H,a,n,n,a,h]
 *      Output: [h,a,n,n,a,H]
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/reverse-string/
 * @since   2020-03-12 22:41:16
 */
public class L0344_Reverse_String {
    static class Solution {
        public void reverseString(char[] s) {
            int n = s.length;
            if (n == 0) return;
            for (int i = 0; i < n/2; i++) {
                char t= s[i];
                s[i] = s[n-i-1];
                s[n-i-1] = t;
            }
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
