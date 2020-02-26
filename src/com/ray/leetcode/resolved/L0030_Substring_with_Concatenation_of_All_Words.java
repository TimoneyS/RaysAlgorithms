package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    /**
     * 注意题目中所有的单词长度一致，那么每个单词长 m， n个单词长 n*m
     * 原字符串可以分为 s.length() - n * m 个 长度为 n*m 的子串
     * 检查每个子串是否可以由给定的单词组成即可
     */
    static class Solution {
        public List<Integer> findSubstring(String s, String[] words) {

            int totalLength = 0;
            int n = 0;
            Map<String, Integer> wordMap = new HashMap<>();
            for (String word : words) {
                wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
                totalLength += word.length();
                n = word.length();
            }

            List<Integer> l = new ArrayList<>();
            if (totalLength == 0 || n == 0) {
                return l;
            }
            for (int i = 0; i <= s.length()-totalLength; i ++) {
                Map<String, Integer> tempMap = new HashMap<>();
                int j = i;
                for (; j < i + totalLength; j += n) {
                    String word = s.substring(j, j+n);
                    if (!wordMap.containsKey(word)) {
                        break;
                    }
                    tempMap.put(word, tempMap.getOrDefault(word, 0) + 1);
                    if (tempMap.get(word) > wordMap.get(word)) {
                        break;
                    }
                }

                if (j != 0 && j == i +totalLength) {
                    l.add(i);
                }
            }
            return l;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
