package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a boolean expression with following symbols.
 *      ```
 *      Symbols
 *          'T' ---> true 
 *          'F' ---> false 
 *      ```
 *      And following operators filled between symbols
 *      
 *      ```
 *      Operators
 *          &   ---> boolean AND
 *          |   ---> boolean OR
 *          ^   ---> boolean XOR 
 *      ```
 *      
 *      Count the number of ways we can parenthesize the expression so that the value of expression evaluates to true.
 *      
 *      Let the input be in form of two arrays one contains the symbols (T and F) in order and other contains operators (&, | and ^}
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input： ['T', 'F', 'T']，['^', '&']
 *      Output：2
 *      Explanation：
 *      The given expression is "T ^ F & T", it evaluates true, in two ways "((T ^ F) & T)" and "(T ^ (F & T))"
 *      ```
 *      
 *      **Example 2:**
 *      ```
 *      Input：['T', 'F', 'F']，['^', '|']
 *      Output：2
 *      Explanation：
 *      The given expression is "T ^ F | F", it evaluates true, in two ways "( (T ^ F) | F )" and "( T ^ (F | F) )".
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/boolean-parenthesization/description
 * @date   2019-07-11 18:35:50
 */
public class L_0725_Boolean_Parenthesization {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
