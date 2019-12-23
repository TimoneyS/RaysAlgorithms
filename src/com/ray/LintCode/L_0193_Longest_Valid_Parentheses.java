package com.ray.LintCode;

import com.ray.io.Out;

import java.util.Stack;

/**
 * 描述：
 *      Given a string containing just the characters,
 *      find the length of the longest valid (well-formed) parentheses substring.
 *
 * 用例：
 *      **用例 1:**
 *      输入: "(()"
 *      输出: 2
 *      解释: The longest valid parentheses substring is "()"
 *
 *      **用例 2:**
 *      输入: ")()())"
 *      输出: 4
 *      解释: The longest valid parentheses substring is "()()"
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.com/problem/longest-valid-parentheses/description
 * @date   2019-12-24 00:23:20
 */
public class L_0193_Longest_Valid_Parentheses {

    /**
     *
     *
     *
     *
     */
    static class Solution {

        public int longestValidParentheses(String s) {
            Stack<Integer> stack = new Stack<Integer>();
            s = ")" + s;
            char L = '(';
            int rs = 0;
            for (int i = 0; i < s.length(); i ++)
            {
                char c = s.charAt(i);
                if (c == L) {
                    stack.push(i);
                } else {
                    if (!stack.empty()) {
                        stack.pop();
                    }
                    if (!stack.empty()) {
                        rs = Math.max(rs, i - stack.peek());
                    } else {
                        stack.push(i);
                    }
                }
            }

            return rs;
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}