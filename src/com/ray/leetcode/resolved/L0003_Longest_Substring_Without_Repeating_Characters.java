package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Longest Substring Without Repeating Characters
 *
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example:
 *      Example 1
 *      Input: abcabcbb
 *      Output: 3 
 *      Explanation: The answer is abc, with the length of 3. 
 *      Example 2
 *      Input: bbbbb
 *      Output: 1
 *      Explanation: The answer is b, with the length of 1.
 *      Example 3
 *      Input: pwwkew
 *      Output: 3
 *      Explanation: The answer is wke, with the length of 3. 
 *                   Note that the answer must be a substring, pwke is a subsequence and not a substring.
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * @since   2020-02-13 19:49:49
 */
public class L0003_Longest_Substring_Without_Repeating_Characters {
    /**
     * 不断的前行，并记录每个字符出现的次数
     *      若字符不重复，则将长度+1
     *      若字符出现重复，则将长度截断到上一次该字符出现的位置
     *      同时不断记录长度的最大值
     */
    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            boolean[] cache = new boolean[256];
            int max = 0, l = 0;
            for (int i = 0; i < s.length(); i++) {
                while (cache[s.charAt(i)]) {
                    cache[s.charAt(l)] = false;
                    if (s.charAt(l++) == s.charAt(i))
                        break;
                }
                cache[s.charAt(i)] = true;
                max = Math.max(max, i - l + 1);
            }
            return max;
        }
    }
    
    public static void main(String[] args) {
        String s = "abcabcbb";
        Out.p(new Solution().lengthOfLongestSubstring(s));
    }
}
