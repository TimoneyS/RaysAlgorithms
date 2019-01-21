package com.ray.LintCode;

import java.util.Stack;

import com.ray.io.Out;

/**
 * 计算逆波兰表达式
 * 
 * 有效的运算符是+， - ，*，/ ，每个操作数可以是整数或另一个表达式。
 *
 * ["2", "1", "+", "3", "*"]    -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"]   -> (4 + (13 / 5)) -> 6
 *
 * @author rays1
 *
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
