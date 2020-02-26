package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.Stack;

/**
 * Longest Valid Parentheses
 *
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 *
 * Example:
 *      Example 1
 *      Input: (()
 *      Output: 2
 *      Explanation: The longest valid parentheses substring is ()
 *      Example 2
 *      Input: )()())
 *      Output: 4
 *      Explanation: The longest valid parentheses substring is ()()
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/longest-valid-parentheses/
 * @since   2020-02-26 19:21:08
 */
public class L0032_Longest_Valid_Parentheses {
    /**
     * 将字符串中连续的匹配的括号对去除后
     * 剩下的不能够匹配的单独的括号，他们之间的距离就是最长连续括号对
     * 如：
     *      )())(())((()()()(
     * 删除括号对后：
     *      )..)....((......(
     * 最长的括号对是6
     */
    static class Solution {
        public int longestValidParentheses(String s) {
            Stack<Integer> stack = new Stack<>();
            int rs = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (!stack.isEmpty() && c == ')' && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                    rs = Math.max(rs, i - (stack.isEmpty() ? - 1 : stack.peek()));
                } else {
                    stack.push(i);
                }
            }
            return rs;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
