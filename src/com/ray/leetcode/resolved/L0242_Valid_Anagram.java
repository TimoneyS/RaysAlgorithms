package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Valid Anagram
 * -----------------------------------------------------------------------------
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 *
 * Example:
 *      Example 1
 *      Input: s = anagram, t = nagaram
 *      Output: true
 *      Example 2
 *      Input: s = rat, t = car
 *      Output: false
 *      Note:
 *      You may assume the string contains only lowercase alphabets.
 *      Follow up:
 *      What if the inputs contain unicode characters? How would you adapt your solution to such case?
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/valid-anagram/
 * @since   2020-03-09 21:44:56
 */
public class L0242_Valid_Anagram {
    static class Solution {

        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) return false;
            int[] count = new int[256];
            for (int i = 0; i < s.length(); i++)  count[s.charAt(i)] ++;
            for (int i = 0; i < t.length(); i++) {
                count[t.charAt(i)] --;
                if (count[t.charAt(i)] < 0) return false;
            }
            return true;
        }

    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
