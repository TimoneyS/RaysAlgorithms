package com.ray.LintCode.resolved;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import com.ray.io.Out;

/**
 * 验证括号
 *
 *
 * @author rays1
 *
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
