package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      k 个字符串，寻找最长的共同前缀
 *
 * 用例：
 *      Example 1:
 *      	Input:  "ABCD", "ABEF", "ACEF"
 *      	Output:  "A"
 *
 *      Example 2:
 *      	Input: "ABCDEFG", "ABCEFG" and "ABCEFA"
 *      	Output:  "ABC"
 *
 * 难度： Medium
 *
 * @author rays1
 * @link   https://www.lintcode.cn/problem/longest-common-prefix/description
 * @since  2019-07-11 18:29:55
 */
public class L_0078_Longest_Common_Prefix {
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
        String[] strs = {"A","B"};
        Out.p("\"" + new Solution().longestCommonPrefix(strs) + "\"");
    }
}
