package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Word Pattern
 * -----------------------------------------------------------------------------
 * Given a pattern and a string str, find if str follows the same pattern.
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 *
 * Example:
 *      Example 1
 *      Input: pattern = abba, str = dog cat cat dog
 *      Output: true
 *      Example 2
 *      Input:pattern = abba, str = dog cat cat fish
 *      Output: false
 *      Example 3
 *      Input: pattern = aaaa, str = dog cat cat dog
 *      Output: false
 *      Example 4
 *      Input: pattern = abba, str = dog dog dog dog
 *      Output: false
 *      Notes:
 *      You may assume pattern contains only lowercase letters, and str contains lowercase letters that may be separated by a single space.
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/word-pattern/
 * @since   2020-03-11 00:15:08
 */
public class L0290_Word_Pattern {
    static class Solution {
        public boolean wordPattern(String pattern, String str) {
            Scanner sc = new Scanner(str);
            Map<Character, Integer> map1 = new HashMap<>();
            Map<Integer, Character> map2 = new HashMap<>();
            for (int i = 0; i < pattern.length(); i++) {
                if (!sc.hasNext()) return false;
                int  h = sc.next().hashCode();
                char c = pattern.charAt(i);
                if (map1.containsKey(c) && map2.containsKey(h)) {
                    if (map1.get(c) != h || map2.get(h) != c) {
                        return false;
                    }
                } else if (!map1.containsKey(c) && !map2.containsKey(h)) {
                    map1.put(c, h);
                    map2.put(h, c);
                } else {
                    return false;
                }
            }
            return !sc.hasNext();
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
