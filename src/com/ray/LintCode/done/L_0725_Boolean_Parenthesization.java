package com.ray.LintCode.done;

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

    /**
     * 设 
     *      dpP[i][j] 表示 i，j 之间，能够构成的 t 的表达式加括号方式数量
     *      dpN[i][j] 表示 i，j 之间，能够构成的 f 的表达式加括号方式数量
     *      
     * @author rays1
     *
     */
    static class Solution {
    
        public int countParenth(char[] symb, char[] oper) {
            if(symb == null || symb.length == 0 || oper == null || oper.length == 0) return 0;
            int n = symb.length;
            int[][] dpP = new int[n][n];
            int[][] dpN = new int[n][n];
            for(int i = 0;i < n;i ++){
                if(symb[i] == 'T'){
                    dpP[i][i] = 1;
                }else{
                    dpN[i][i] = 1;
                }
            }
            
            for(int j=0;j<n;j++){
                for(int i=j-1;i>=0;i--){
                    dpP[i][j] = 0;
                    dpN[i][j] = 0;
                    
                    for(int k=i;k<j;k++){
                        
                        if (oper[k] == '&') {
                            dpP[i][j] += dpP[i][k]*dpP[k+1][j];
                            dpN[i][j] += (dpP[i][k] + dpN[i][k]) * (dpP[k+1][j] + dpN[k+1][j]) - dpP[i][k] * dpP[k+1][j];
                        }
                        
                        if (oper[k] == '|') {
                            dpP[i][j] += (dpP[i][k] + dpN[i][k]) * (dpP[k+1][j] + dpN[k+1][j]) - dpN[i][k] * dpN[k+1][j];
                            dpN[i][j] += dpN[i][k]*dpN[k+1][j];
                        }
                        
                        if (oper[k] == '^') {
                            dpP[i][j] += dpP[i][k]*dpN[k+1][j] + dpN[i][k]*dpP[k+1][j];
                            dpN[i][j] += dpP[i][k]*dpP[k+1][j] + dpN[i][k]*dpN[k+1][j];
                        }
                        
                    }
                }
            }
            return dpP[0][n-1];
        }

    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
