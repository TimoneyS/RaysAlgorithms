package com.ray.LintCode.done;

import com.ray.io.Out;

import java.util.Stack;
import java.util.stream.StreamSupport;

/**
 * 描述：
 *     给定一个字符串，寻找最长的括号匹配的子串
 * 用例：
 * **用例 1:**
 * 输入: "(()"
 * 输出: 2
 * 解释: The longest valid parentheses substring is "()"
 * <p>
 * **用例 2:**
 * 输入: ")()())"
 * 输出: 4
 * 解释: The longest valid parentheses substring is "()()"
 * <p>
 * 难度： Simple
 *
 * @author rays1
 * @url https://www.lintcode.com/problem/longest-valid-parentheses/description
 * @date 2019-12-24 00:23:20
 */
public class L_0193_Longest_Valid_Parentheses {

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

        String s = "(()())))";
//        String s = "(()";
        Out.p(new Solution().longestValidParentheses(s));

    }

}