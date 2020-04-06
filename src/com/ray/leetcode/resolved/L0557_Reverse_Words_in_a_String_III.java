package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Reverse Words in a String III
 * -----------------------------------------------------------------------------
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 *
 * Example:
 *      Example 1
 *      Input: "Let's take LeetCode contest"
 *      Output: "s'teL ekat edoCteeL tsetnoc"
 *      Note:
 *      In the string, each word is separated by single space and there will not be any extra space in the string.
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
 * @since   2020-04-06 23:22:52
 */
public class L0557_Reverse_Words_in_a_String_III {
    /**
     * 直接遍历，遇到空格或者解尾时，反向回溯将字符添加到结果中。
     */
    static class Solution {
        public String reverseWords(String s) {
            StringBuilder sb = new StringBuilder();
            int l = 0;
            for (int i = 0; i <= s.length(); i++) {
                char c = i == s.length() ? ' ' : s.charAt(i);
                if (c == ' ') {
                    for (int j = i-1; j >= l; j--) {
                        sb.append(s.charAt(j));
                    }
                    if (i < s.length()) sb.append(' ');
                    l = i+1;
                }
            }
            return sb.toString();
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
