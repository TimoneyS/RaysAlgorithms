package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Count and Say
 *
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 is read off as one 1 or 11.
 * 11 is read off as two 1s or 21.
 * 21 is read off as one 2, then one 1 or 1211.
 * Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence. You can do so recursively, in other words from the previous member read off the digits, counting the number of digits in groups of the same digit.
 * Note: Each term of the sequence of integers will be represented as a string.
 *
 * Example:
 *      Example 1
 *      Input: 1
 *      Output: 1
 *      Explanation: This is the base case.
 *      Example 2
 *      Input: 4
 *      Output: 1211
 *      Explanation: For n = 3 the term was 21 in which we have two groups 2 and 1, 2 can be read as 12 which means frequency = 1 and value = 2, the same way 1 is read as 11, so the answer is the concatenation of 12 and 11 which is 1211.
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/count-and-say/
 * @since   2020-02-26 19:17:36
 */
public class L0038_Count_and_Say {
    /**
     * 提供 next 方法
     * next方法统计字符串中每段连续字符的长度和字符本身，加入新的字符串中
     */
    static class Solution {
        public String countAndSay(int n) {
            String s = "1";
            for (int i = 1; i < n; i ++) {
                s = next(s);
            }
            return s;
        }

        public String next(String s) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            for (int i = 0; i < s.length(); i ++) {
                if (i < s.length() -1 && s.charAt(i) == s.charAt(i+1)) {
                    count ++;
                } else {
                    sb.append(count).append(s.charAt(i));
                    count = 1;
                }
            }
            return sb.toString();
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}