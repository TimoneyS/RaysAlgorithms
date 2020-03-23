package com.ray.leetcode.resolved;

import com.ray.io.Out;
import com.ray.leetcode.util.NestedInteger;

import java.util.Stack;

/**
 * Mini Parser
 * -----------------------------------------------------------------------------
 * Given a nested list of integers represented as a string, implement a parser to deserialize it.
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 * Note:
 * You may assume that the string is well-formed:
 * String is non-empty.
 * String does not contain white spaces.
 * String contains only digits 0-9, [, - ,, ].
 *
 * Example:
 *      Example 1
 *      Given s = "324",
 *      You should return a NestedInteger object which contains a single integer 324.
 *      Example 2
 *      Given s = "[123,[456,[789]]]",
 *      Return a NestedInteger object containing a nested list with 2 elements:
 *      1. An integer containing value 123.
 *      2. A nested list containing two elements:
 *          i.  An integer containing value 456.
 *          ii. A nested list with one element:
 *               a. An integer containing value 789.
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/mini-parser/
 * @since   2020-03-23 21:52:50
 */
public class L0385_Mini_Parser {
    static class Solution {
        public NestedInteger deserialize(String s) {

            Stack<NestedInteger> stack = new Stack<>();
            int number = 0, symbol = 1;
            for (int i = 0; i < s.length(); i ++) {
                char c = s.charAt(i);
                if (c == '[') {
                    stack.push(new NestedInteger());
                } else if (c <= '9' && c >= '0') {
                    number = number * 10 + c-'0';
                    if (i+1 == s.length() || s.charAt(i+1) < '0' || s.charAt(i+1) > '9') {
                        if (stack.empty()) stack.add(new NestedInteger(number * symbol));
                        else stack.peek().add(new NestedInteger(number * symbol));
                        number = 0;
                        symbol = 1;
                    }
                } else if (c == ']') {
                    if (i != s.length() - 1) {
                        NestedInteger t = stack.pop();
                        stack.peek().add(t);
                    }
                } else if (c == '-') {
                    symbol = -1;
                }
            }

            return stack.peek();
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
