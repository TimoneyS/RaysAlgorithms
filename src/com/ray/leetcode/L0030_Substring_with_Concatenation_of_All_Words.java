package com.ray.leetcode;

import com.ray.io.Out;

import java.util.List;

/**
 * Substring with Concatenation of All Words
 *
 * You are given a string, s, and a list of words, words, that are all of the same length.
 * Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once
 * and without any intervening characters.
 *
 * Example:
 *      Example 1
 *      Input:
 *        s = barfoothefoobarman,
 *        words = [foo,bar]
 *      Output: [0,9]
 *      Explanation: Substrings starting at index 0 and 9 are barfoo and foobar respectively.
 *      The output order does not matter, returning [9,0] is fine too.
 *      Example 2
 *      Input:
 *        s = wordgoodgoodgoodbestword,
 *        words = [word,good,best,word]
 *      Output: []
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words/
 * @since   2020-02-25 22:47:31
 */
public class L0030_Substring_with_Concatenation_of_All_Words {
    static class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            return null;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
