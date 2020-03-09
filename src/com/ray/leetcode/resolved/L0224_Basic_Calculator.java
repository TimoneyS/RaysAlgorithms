package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.Stack;

/**
 * Basic Calculator
 * -----------------------------------------------------------------------------
 * Implement a basic calculator to evaluate a simple expression string.
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces  .
 *
 * Example:
 *      Example 1
 *      Input: 1 + 1
 *      Output: 2
 *      Example 2
 *      Input:  2-1 + 2 
 *      Output: 3
 *      Example 3
 *      Input: (1+(4+5+2)-3)+(6+8)
 *      Output: 23
 *      Note:
 *      	You may assume that the given expression is always valid.
 *      	Do not use the eval built-in library function.
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/basic-calculator/
 * @since   2020-03-09 21:28:01
 */
public class L0224_Basic_Calculator {
    static class Solution {

        public int calculate(String s) {
            Stack<Character> op = new Stack<>();
            Stack<Integer>   opw = new Stack<>();
            Stack<Integer> on = new Stack<>();
            int base  = 0;
            for (int i = 0;i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(')       base += 10;
                else if (c == ')')  base -= 10;
                else if (c == ' ') continue;
                else if (isDigit(c)) {
                    int n = c- '0';
                    while (i < s.length()-1 && isDigit(s.charAt(i+1))) {
                        n = n * 10 + s.charAt(i+1) - '0';
                        i++;
                    }
                    on.push(n);
                } else {
                    int w = weight(c, base);
                    while (!op.isEmpty() && w <= opw.peek()) {
                        int r = on.pop();
                        int l = on.pop();
                        char oper = op.pop();
                        opw.pop();
                        on.push(exec(l, r, oper));
                    }
                    op.push(c);
                    opw.add(weight(c, base));
                }

            }

            int r = on.pop();
            while(!op.isEmpty()) {
                char oper = op.pop();
                int l = on.pop();
                r = exec(l, r, oper);
            }
            return r;
        }

        private Integer exec(int l, int r, char oper) {
            switch(oper) {
                case '+': return l+r;
                case '-': return l-r;
                case '*': return l*r;
                default : return l/r;
            }
        }

        private int weight(char op, int base) {
            if (op == '*' || op == '/') return base + 2;
            return base + 1;
        }

        private boolean isDigit(char c) {return c >= '0' && c <= '9';}
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
