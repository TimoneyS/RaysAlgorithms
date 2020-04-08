package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.Stack;

/**
 * Calculator LCCI
 * -----------------------------------------------------------------------------
 * Given an arithmetic equation consisting of positive integers, +, -, * and / (no paren&shy;theses), compute the result.
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.
 *
 * Example:
 *      Example 1
 *      Input: 3+2*2
 *      Output: 7
 *      Example 2
 *      Input:  3/2 
 *      Output: 1
 *      Example 3
 *      Input:  3+5 / 2 
 *      Output: 5
 *      Note:
 *      	You may assume that the given expression is always valid.
 *      	Do not use the eval built-in library function.
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/calculator-lcci/
 * @since   2020-04-08 22:04:54
 */
public class L1000027_Calculator_LCCI {
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
