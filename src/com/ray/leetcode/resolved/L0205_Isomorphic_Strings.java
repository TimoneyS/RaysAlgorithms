package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.HashMap;
import java.util.Map;

/**
 * Isomorphic Strings
 * -----------------------------------------------------------------------------
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
 *
 * Example:
 *      Example 1
 *      Input: s = egg, t = add
 *      Output: true
 *      Example 2
 *      Input: s = foo, t = bar
 *      Output: false
 *      Example 3
 *      Input: s = paper, t = title
 *      Output: true
 *      Note:
 *      You may assume both s and t have the same length.
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/isomorphic-strings/
 * @since   2020-03-08 23:52:56
 */
public class L0205_Isomorphic_Strings {
    /**
     * 一边循环，一边构建映射（两字符串同一位置的字符，都是映射）
     * 如果发现新的字符映射和已经构建的映射不符合，则返回false
     */
    static class Solution {
        public boolean isIsomorphic(String s, String t) {
            if (s.length() != t.length()) return false;
            Map<Character, Character> map = new HashMap<>();
            Map<Character, Character> map2 = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char c1 = s.charAt(i);
                char c2 = t.charAt(i);
                if (map.containsKey(c1) || map2.containsKey(c2)) {
                    if ( map.containsKey(c1) &&  map.get(c1) != c2) return false;
                    if (map2.containsKey(c2) && map2.get(c2) != c1) return false;
                } else {
                    map.put(c1, c2);
                    map2.put(c2, c1);
                }
            }
            return true;
        }
    }
    
    public static void main(String[] args) {
        String s = "aac";
        String t = "tta";
        Out.p(new Solution().isIsomorphic(s, t));
    }
}
