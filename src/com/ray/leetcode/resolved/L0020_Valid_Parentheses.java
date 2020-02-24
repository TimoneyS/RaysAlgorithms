package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Valid Parentheses
 *
 * Given a string containing just the characters &#39;(&#39;, &#39;)&#39;, &#39;{&#39;, &#39;}&#39;, &#39;[&#39; and &#39;]&#39;, determine if the input string is valid.
 * An input string is valid if:
 * 	Open brackets must be closed by the same type of brackets.
 * 	Open brackets must be closed in the correct order.
 * Note that an empty string is&nbsp;also considered valid.
 *
 * Example:
 *      Example 1
 *      Input: ()
 *      Output: true
 *      Example 2
 *      Input: ()[]{}
 *      Output: true
 *      Example 3
 *      Input: (]
 *      Output: false
 *      Example 4
 *      Input: ([)]
 *      Output: false
 *      Example 5
 *      Input: {[]}
 *      Output: true
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/valid-parentheses/
 * @since   2020-02-24 21:11:46
 */
public class L0020_Valid_Parentheses {
    static class Solution {
        static Map<Character, Integer> hash = new HashMap<>();
        static {
            hash.put('{',  1);
            hash.put('[',  2);
            hash.put('(',  3);
            hash.put('}', -1);
            hash.put(']', -2);
            hash.put(')', -3);
        }

        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                int v = hash.get(c);
                if (v > 0) { // 右括号
                    stack.push(c);
                } else if (stack.isEmpty() || hash.get(stack.peek()) + v != 0) { // 遇到不能匹配的左括号
                    return false;
                } else { // 弹出左括号
                    stack.pop();
                }
            }
            return stack.isEmpty();
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
