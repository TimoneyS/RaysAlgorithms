package com.ray.LintCode.done;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import com.ray.io.Out;

/**
 * 描述：
 *      Given n, and there are n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: 3
 *      Output: ["((()))", "(()())", "(())()", "()(())", "()()()"]
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input: 2
 *      Output: ["()()", "(())"]
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/generate-parentheses/description
 * @date   2019-07-11 18:33:01
 */
public class L_0427_Generate_Parentheses {


    /**
     * 试想 n = 3 三对括号的情况
     * 
     * 1.第一个只能是左括号 (
     * 
     * 然后分两种情况：
     *      2.1 第二个可以是左括号 ((
     *          3.1 第三个可以是左括号 (((
     *              4.1 第四个只能是右括号，因为左括号用完了 ((()
     *              ...
     *          3.2 第三个可以是右括号 (()
     *          ..
     *      2.2 第二个是右括号 ()
     *          3.1 第三个只能是左括号，因此前两个括号互相匹配了 ()(
     *          ..
     *  
     * 因此可以总结如下，只要之前左右括号全部互相了匹配，下一个字符只能是左括号了
     *                 只要之前的左右括号不能全部匹配，下一个字符可能是右括号也可能是左括号，
     * 
     * 可以用 left 和 right 表示剩下的左括号和右括号的数量，用一个栈保存已经放置的括号字符
     * 如果 left == right 栈中的左右括号互相匹配，此时只能向栈中放入左括号(left - 1)
     * 除此之外，左右括号都可以放入(left - 1 or right - 1)
     * 算法保证了left 一定是 <= right 的，因此不会出现错位的情况
     * 
     * @author rays1
     *
     */
    static class Solution {
        
        Map<Integer, List<String>> cache = new HashMap<>();
    
        public List<String> generateParenthesis(int n) {
            
            int left = n, right = n;
            Stack<Character> stack = new Stack<>();
            List<String> rs = new ArrayList<>();
            
            helper(rs, stack, left, right);
            
            return rs;
        }

        private void helper(List<String> rs, Stack<Character> stack, int left, int right) {
            
            if (left == 0 && right == 0) {
                StringBuilder sb = new StringBuilder();
                for (char c : stack) {
                    sb.append(c);
                }
                rs.add(sb.toString());
            } else {
                
                if (left > 0) {
                    stack.push('(');
                    helper(rs, stack, left - 1, right);
                    stack.pop();
                }
                
                if (left < right) {
                    stack.push(')');
                    helper(rs, stack, left, right - 1);
                    stack.pop();
                }
                
            }
        }
    
    }
    
    public static void main(String[] args) {
        
        int n  = 3;
        
        Out.p(new Solution().generateParenthesis(n));
        
    }

}
