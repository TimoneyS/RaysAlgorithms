package com.ray.LintCode.done;

import java.util.Stack;

import com.ray.io.Out;

/**
 * 描述：
 *      Implement a basic calculator to evaluate a simple expression string.
 *      
 *      The expression string may contain open `(` and closing parentheses `)`, the plus `+` or minus sign `-`, `non-negative` integers and empty spaces .
 *      
 *      The expression string contains only non-negative integers, `+`, `-`, `*`, `/` operators , open `(` and closing parentheses `)` and empty spaces . The integer division should truncate toward zero.
 *      
 *      You may assume that the given expression is always valid. All intermediate results will be in the range of `[-2147483648, 2147483647]`
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input："1 + 1"
 *      Output：2
 *      Explanation：1 + 1 = 2
 *      ```
 *      
 *      
 *      **Example 2:**
 *      ```
 *      Input：" 6-4 / 2 "
 *      Output：4
 *      Explanation：4/2=2，6-2=4
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/basic-calculator-iii/description
 * @date   2019-07-11 18:37:35
 */
public class L_0849_Basic_Calculator_III {

    /**
     * 用栈维护操作符和其优先级，优先级高先算。
     * 
     * 当遇到一个操作符时，对栈中所有优先级高于该操作符的元素执行计算。
     * 
     * @author rays1
     *
     */
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
