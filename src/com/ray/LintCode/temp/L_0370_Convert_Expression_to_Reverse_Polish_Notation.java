package com.ray.LintCode.temp;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a string array representing an expression, and return the Reverse Polish notation of this expression. (remove the parentheses)
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: ["3", "-", "4", "+", "5"]
 *      Output: ["3", "4", "-", "5", "+"]
 *      Explanation: 3 - 4 + 5 = -1 + 5 = 4
 *          3 4 - 5 + = -1 5 + = 4
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input: ["(", "5", "-", "6", ")", "*", "7"]
 *      Output: ["5","6","-","7","*"]
 *      Explanation: (5 - 6) * 7 = -1 * 7 = -7
 *          5 6 - 7 * = -1 7 * = -7
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/convert-expression-to-reverse-polish-notation/description
 * @date   2019-07-11 18:32:14
 */
public class L_0370_Convert_Expression_to_Reverse_Polish_Notation {

    /**
     * 中序遍历的结果变后序遍历
     * 用一个单调递增的栈保存操作符，遵循如下规则：
     *      1.遇到数字则直接加入结果列表
     *      2.遇到操作符，若操作符小于栈中的操作符，则依次弹出栈中权重大的操作符，加入结果队列
     * 
     * @author rays1
     *
     */
    static class Solution {
        public List<String> convertToRPN(String[] expression) {
            
            ArrayList<String> rs = new ArrayList<>();
            
            Stack<String>  operStack = new Stack<>();
            Stack<Integer> deepStack = new Stack<>();
            
            int base = 0;
            for (String str : expression) {
                if (str.equals("(")) {base += 3; continue;}
                if (str.equals(")")) {base -= 3; continue;}
                
                int deep = deep(base, str);
                if (deep == Integer.MAX_VALUE) { rs.add(str);continue; }
                
                // 栈中的元素是单调递增的
                while (!deepStack.isEmpty() && deepStack.peek() >= deep) {
                    deepStack.pop();
                    rs.add(operStack.pop());
                }
                
                deepStack.push(deep);
                operStack.push(str);
                
            }
            
            while (!operStack.isEmpty()) {
                rs.add(operStack.pop());
            }
            
            return rs;
        }
        
        // 权重，数字的权重最高，操作符的权重 乘除 大于 加减
        public int deep(int base, String s) {
            if (s.equals("+") || s.equals("-")) return base;
            if (s.equals("*") || s.equals("/")) return base + 1;
            return Integer.MAX_VALUE;
        }
        
    }
    
    public static void main(String[] args) {
        
        String[] expression = {"(", "3",  "+",  "4", ")",  "*" , "5",  "-",  "6"};
        
        // String[] expression = {"2","*","6","-","(","23","+","7",")","/","(","1","+","2",")"};
        
        Out.p(new Solution().convertToRPN(expression));
        
    }

}
