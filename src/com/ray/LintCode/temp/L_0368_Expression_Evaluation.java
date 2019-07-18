package com.ray.LintCode.temp;

import java.util.Stack;

import com.ray.io.Out;

/**
 * 描述：
 *      Given an expression string array, return the final result of this expression
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      For the expression `2*6-(23+7)/(1+2)`,
 *      Input:
 *      ["2", "*", "6", "-", "(","23", "+", "7", ")", "/", "(", "1", "+", "2", ")"]
 *      Output:
 *      2
 *      ```
 *      
 *      **Example 2:**
 *      ```
 *      For the expression `4-(2-3)*2+5/5`,
 *      Input:
 *      ["4", "-", "(", "2","-", "3", ")", "*", "2", "+", "5", "/", "5"]
 *      Output:
 *      7
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/expression-evaluation/description
 * @date   2019-07-11 18:32:13
 */
public class L_0368_Expression_Evaluation {


    /**
     * 维护单调增的操作符栈，如果操作的权重小于栈中的操作符，则计算栈中的操作符
     * 直到可以将操作符入栈
     * @author rays1
     *
     */
    static class Solution {
        /**
         * @param expression: a list of strings
         * @return: an integer
         */
        public int evaluateExpression(String[] expression) {
            if (expression == null || expression.length == 0) return 0;
            
            Stack<String>  operStack = new Stack<>();
            Stack<Integer> deepStack = new Stack<>();
            Stack<Integer> valuStack = new Stack<>();
            
            int base = 0;
            for (String val : expression) {
                
                if (val.equals("(")) {base += 2; continue;}
                if (val.equals(")")) {base -= 2; continue;}
                
                int deep = deep(base, val);
                if (deep == Integer.MAX_VALUE) { valuStack.push(Integer.valueOf(val)); continue; }
                
                Out.p(valuStack);
                
                // 栈中的元素是单调递增的
                while (!deepStack.isEmpty() && deepStack.peek() >= deep) {
                    deepStack.pop();
                    String oper = operStack.pop();
                    
                    Integer n2 = valuStack.pop();
                    Integer n1 = valuStack.pop();
                    
                    valuStack.push(calcu(oper, n1, n2));
                    
                }
                
                deepStack.push(deep);
                operStack.push(val);
                
            }
            
            while (!operStack.isEmpty()) {
                String oper = operStack.pop();
                
                Integer n2 = valuStack.pop();
                Integer n1 = valuStack.pop();
                
                valuStack.push(calcu(oper, n1, n2));
            }
            
            return valuStack.isEmpty() ? 0 : valuStack.pop();
        }
        
        private int calcu(String oper, Integer n1, Integer n2) {
            Out.pf("%s%s%s\n", n1, oper, n2);
            
            switch(oper) {
                case "*" : return n1 * n2;
                case "/" : return n1 / n2;
                case "+" : return n1 + n2;
                case "-" : return n1 - n2;
            }
            return 0;
        }

        // 权重，数字的权重最高，操作符的权重 乘除 大于 加减
        public int deep(int base, String s) {
            if (s.equals("+") || s.equals("-")) return base;
            if (s.equals("*") || s.equals("/")) return base + 1;
            return Integer.MAX_VALUE;
        }
        
    }
    
    public static void main(String[] args) {
        
//        String[] expression = {"2","*","6","-","(","23","+","7",")","/","(","1","+","2",")"};
        String[] expression = {"(","999","/","3","/","3","/","3",")","+","(","1","+","9","/","3",")"};
        
        Out.p(new Solution().evaluateExpression(expression));
        
    }

}
