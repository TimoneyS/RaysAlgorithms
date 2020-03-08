package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.List;

/**
 * Word Break
 * -----------------------------------------------------------------------------
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * Note:
 * 	The same word in the dictionary may be reused multiple times in the segmentation.
 * 	You may assume the dictionary does not contain duplicate words.
 *
 * Example:
 *      Example 1
 *      Input: s = leetcode, wordDict = [leet, code]
 *      Output: true
 *      Explanation: Return true because leetcode can be segmented as leet code.
 *      Example 2
 *      Input: s = applepenapple, wordDict = [apple, pen]
 *      Output: true
 *      Explanation: Return true because applepenapple can be segmented as apple pen apple.
 *                   Note that you are allowed to reuse a dictionary word.
 *      Example 3
 *      Input: s = catsandog, wordDict = [cats, dog, sand, and, cat]
 *      Output: false
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/word-break/
 * @since   2020-03-07 20:20:22
 */
public class L0139_Word_Break {
    static class Solution {

        boolean[] canBreak;

        public boolean wordBreak(String s, List<String> dict) {
            if (s.length() == 0) return true;
            if (dict.size() == 0) return false;
            canBreak = new boolean[s.length()];
            int m = -1;
            for (int i = 1; i <= s.length(); i++) {
                for (int j = m; j >= -1; j --) {
                    if (j != -1 && !canBreak[j]) continue;
                    if(isInDict(s, j+1, i, dict)){
                        m = i-1;
                        canBreak[m] = true;
                        break;
                    }
                }
            }
            return canBreak[s.length()-1];
        }

        public boolean isInDict(String tar, int s, int t, List<String> dict) {
            for (String src : dict) {
                if (src.length() != t - s)
                    continue;
                int i = 0;
                for (; i < src.length(); i++) {
                    if (tar.charAt(s+i) != src.charAt(i)) {
                        break;
                    }
                }
                if (i == src.length()) {
                    return true;
                }
            }
            return false;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
