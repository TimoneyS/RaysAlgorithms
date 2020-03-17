package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Find Words That Can Be Formed by Characters
 * -----------------------------------------------------------------------------
 * You are given an array of strings words and a string chars.
 * A string is good if it can be formed by characters from chars (each character can only be used once).
 * Return the sum of lengths of all good strings in words.
 *
 * Example:
 *      Example 1
 *      Input: words = [cat,bt,hat,tree], chars = atach
 *      Output: 6
 *      Explanation: 
 *      The strings that can be formed are cat and hat so the answer is 3 + 3 = 6.
 *      Example 2
 *      Input: words = [hello,world,leetcode], chars = welldonehoneyr
 *      Output: 10
 *      Explanation: 
 *      The strings that can be formed are hello and world so the answer is 5 + 5 = 10.
 *      Note:
 *      	1 <= words.length <= 1000
 *      	1 <= words[i].length, chars.length <= 100
 *      	All strings contain lowercase English letters only.
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-characters/
 * @since   2020-03-17 22:44:22
 */
public class L1112_Find_Words_That_Can_Be_Formed_by_Characters {
    static class Solution {
        public int countCharacters(String[] words, String chars) {
            int[] count = new int[26];
            for (int i = 0; i < chars.length(); i ++) count[chars.charAt(i)-'a'] ++;

            int rs = 0;
            for (String word : words) {
                int[] curr = new int[256];
                for (int i = 0; i <= word.length(); i ++) {
                    if (i == word.length()) {
                        rs += word.length();
                    } else if (curr[word.charAt(i)-'a'] < count[word.charAt(i)-'a']) {
                        curr[word.charAt(i)-'a']++;
                    } else {
                        break;
                    }
                }
            }
            return rs;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
