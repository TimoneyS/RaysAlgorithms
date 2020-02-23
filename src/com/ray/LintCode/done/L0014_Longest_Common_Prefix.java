package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * Longest Common Prefix
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string .
 *
 * Example:
 *      Example 1
 *      Input: [flower,flow,flight]
 *      Output: fl
 *      Example 2
 *      Input: [dog,racecar,car]
 *      Output: 
 *      Explanation: There is no common prefix among the input strings.
 *      Note:
 *      All given inputs are in lowercase letters a-z.
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/longest-common-prefix/
 * @since   2020-02-23 20:59:58
 */
public class L0014_Longest_Common_Prefix {
    /**
     * 多个字符串索引相同的字符，可以构成一列
     *  A A A A
     *  A A B C
     *  A A A B
     * 依次检查每一列，如果某一列不相同则最长的公共前缀到该列为止
     */
    static class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 0) return "";
            if (strs.length == 1) return strs[0];
            int cursor = 0;
            while (true) {
                int ch = -1;
                for (String s : strs) {
                    if (s.length() <= cursor) return s.substring(0, cursor);
                    else if (ch == -1) ch = s.charAt(cursor);
                    else if (ch != s.charAt(cursor)) return s.substring(0, cursor);
                }
                cursor++;
            }
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
