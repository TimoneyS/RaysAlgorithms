package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * First Unique Character in a String
 * -----------------------------------------------------------------------------
 * 
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 * Examples:
 * s = "leetcode"
 * return 0.
 * s = "loveleetcode",
 * return 2.
 * Note: You may assume the string contain only lowercase letters.
 *
 * Example:
 *      
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 * @since   2020-03-23 21:51:31
 */
public class L0387_First_Unique_Character_in_a_String {
    static class Solution {
        public int firstUniqChar(String s) {
            int[] count = new int[26];
            for (int i = 0; i < s.length(); i ++)
                count[s.charAt(i)- 'a'] ++;
            for (int i = 0; i < s.length(); i ++)
                if (count[s.charAt(i)- 'a'] == 1) return i;
            return -1;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
