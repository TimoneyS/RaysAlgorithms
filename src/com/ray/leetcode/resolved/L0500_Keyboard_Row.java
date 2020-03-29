package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.ArrayList;
import java.util.List;

/**
 * Keyboard Row
 * -----------------------------------------------------------------------------
 * Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.
 *
 * Example:
 *      Example 1
 *      Input: [Hello, Alaska, Dad, Peace]
 *      Output: [Alaska, Dad]
 *      Note:
 *      	You may use one character in the keyboard more than once.
 *      	You may assume the input string will only contain letters of alphabet.
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/keyboard-row/
 * @since   2020-03-29 22:56:05
 */
public class L0500_Keyboard_Row {
    static class Solution {
        public String[] findWords(String[] words) {
            int[] line = {1, 2, 2, 1, 0, 1, 1, 1, 0, 1, 1, 1, 2, 2, 0, 0, 0, 0, 1, 0, 0, 2, 0, 2, 0, 2};
            List<String> rs=  new ArrayList<>();
            int l = -1;
            for (String w : words) {
                int cursor = 0;
                while (cursor < w.length()) {
                    int t = line[Character.toLowerCase(w.charAt(cursor)) - 'a'];
                    if (l == -1 ) l = t;
                    if (l != t) break;
                    cursor ++;
                }
                if (cursor == w.length())
                    rs.add(w);
                l = -1;
            }
            return rs.toArray(new String[0]);
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
