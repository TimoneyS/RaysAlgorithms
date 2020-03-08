package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.Stack;

/**
 * Evaluate Reverse Polish Notation
 * -----------------------------------------------------------------------------
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * Note:
 * 	Division between two integers should truncate toward zero.
 * 	The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.
 *
 * Example:
 *      Example 1
 *      Input: [2, 1, +, 3, *]
 *      Output: 9
 *      Explanation: ((2 + 1) * 3) = 9
 *      Example 2
 *      Input: [4, 13, 5, /, +]
 *      Output: 6
 *      Explanation: (4 + (13 / 5)) = 6
 *      Example 3
 *      Input: [10, 6, 9, 3, +, -11, *, /, *, 17, +, 5, +]
 *      Output: 22
 *      Explanation: 
 *        ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 *      = ((10 * (6 / (12 * -11))) + 17) + 5
 *      = ((10 * (6 / -132)) + 17) + 5
 *      = ((10 * 0) + 17) + 5
 *      = (0 + 17) + 5
 *      = 17 + 5
 *      = 22
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 * @since   2020-03-07 21:24:20
 */
public class L0150_Evaluate_Reverse_Polish_Notation {
    /**
     * 使用栈保存数字，遇到操作符则抛出两个数字用于计算，计算结果再存入栈中
     * 最终栈里只剩下一个数字，就是计算结果。
     */
    static class Solution {
        public int evalRPN(String[] tokens) {
            Stack<Integer> stack = new Stack<>();
            for (String s : tokens) {
                if (isOperator(s)) {
                    int n2 = stack.pop();
                    int n1 = stack.pop();
                    stack.push(evalOperator(n1, n2, s));
                } else {
                    stack.push(Integer.valueOf(s));
                }
            }

            return stack.pop();
        }

        boolean isOperator(String s) {
            return s.matches("[+*-/]");
        }

        Integer evalOperator(int n1, int n2, String operator) {
            switch(operator) {
                case "+" : return n1 + n2;
                case "-" : return n1 - n2;
                case "*" : return n1 * n2;
                default  : return n1 / n2;
            }
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
