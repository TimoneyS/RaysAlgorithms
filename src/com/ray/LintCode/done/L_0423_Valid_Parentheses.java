package com.ray.LintCode.done;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a string containing just the characters `'(', ')'`, `'{'`, `'}'`, `'['` and `']'`, determine if the input string is valid.
 *      
 *      The brackets must close in the correct order, `"()"` and `"()[]{}"` are all valid but `"(]"` and `"([)]"` are not.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input: "([)]"
 *      Output: False
 *      ```
 *      **Example 2:**
 *      ```
 *      Input: "()[]{}"
 *      Output: True
 *      ```
 *
 * 挑战：
 *      Use O(n) time, n is the number of parentheses.
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/valid-parentheses/description
 * @date   2019-07-11 18:32:57
 */
public class L_0423_Valid_Parentheses {

    static class Solution {
        
        static Map<Character, Integer> hash = new HashMap<>(); 
        
        static {
            hash.put('{',  1);
            hash.put('}', -1);
            hash.put('[',  2);
            hash.put(']', -2);
            hash.put('(',  3);
            hash.put(')', -3);
        }
        
        public boolean isValidParentheses(String s) {
            Stack<Character> stack = new Stack<>();
            
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                int v = hash.get(c);
                if (v > 0) stack.push(c);
                else if (stack.isEmpty() || hash.get(stack.peek()) + v != 0) {
                    return false;
                } else {
                    stack.pop();
                }
            }
            
            return stack.isEmpty();
        }
    
    }
    
    public static void main(String[] args) {
        
        String s = "]";
        
        Out.p(new Solution().isValidParentheses(s));
        
    }

}
