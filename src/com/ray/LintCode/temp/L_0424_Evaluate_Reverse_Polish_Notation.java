package com.ray.LintCode.temp;

import java.util.Stack;

import com.ray.io.Out;

/**
 * 描述：
 *      Evaluate the value of an arithmetic expression in [Reverse Polish Notation](http://en.wikipedia.org/wiki/Reverse_Polish_notation).
 *      
 *      Valid operators are `+`, `-`, `*`, `/`. Each operand may be an **integer** or another expression.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: ["2", "1", "+", "3", "*"] 
 *      Output: 9
 *      Explanation: ["2", "1", "+", "3", "*"] -> (2 + 1) * 3 -> 9
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input: ["4", "13", "5", "/", "+"]
 *      Output: 6
 *      Explanation: ["4", "13", "5", "/", "+"] -> 4 + 13 / 5 -> 6
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/evaluate-reverse-polish-notation/description
 * @date   2019-07-11 18:32:58
 */
public class L_0424_Evaluate_Reverse_Polish_Notation {

    /**
     * 使用栈保存数字，遇到操作符则抛出两个数字用于计算，计算结果再存入栈中
     * 最终栈里只剩下一个数字，就是计算结果。
     * @author rays1
     *
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
        
        String[] tokens = {"4", "13", "5", "/", "+"};

        
        Out.p(new Solution().evalRPN(tokens));
        
    }

}
