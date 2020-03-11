package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Rotate String
 * -----------------------------------------------------------------------------
 * We are given two strings, A and B.
 * A shift on A consists of taking string A and moving the leftmost character to the rightmost position. For example, if A = 'abcde', then it will be 'bcdea' after one shift on A. Return True if and only if A can become B after some number of shifts on A.
 *
 * Example:
 *      Example 1
 *      Input: A = 'abcde', B = 'cdeab'
 *      Output: true
 *      Example 2
 *      Input: A = 'abcde', B = 'abced'
 *      Output: false
 *      Note:
 *      	A and B will have length at most 100.
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/rotate-string/
 * @since   2020-03-11 21:49:26
 */
public class L0812_Rotate_String {
    static class Solution {
        public boolean rotateString(String A, String B) {
            if (A.length() != B.length()) return false;
            if (A.equals(B)) return true;
            for (int diff = 0; diff < A.length(); diff ++) {
                int c = 0;
                for (int i = 0; i < A.length(); i++) {
                    c ++;
                    if (A.charAt(i) != B.charAt((i+diff) % B.length())) {
                        break;
                    }
                }
                if (c == A.length()) return true;
            }
            return false;
        }

        public static void main(String[] args) {
            Out.p(new Solution().rotateString("abcde", "deabc"));
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
