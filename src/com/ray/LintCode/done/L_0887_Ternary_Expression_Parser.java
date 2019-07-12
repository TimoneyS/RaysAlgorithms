package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a string representing arbitrarily nested ternary expressions, calculate the result of the expression. You can always assume that the given expression is valid and only consists of digits `0-9`, `?`, `:`, `T` and `F` (`T` and `F` represent True and False respectively).
 *
 * 用例：
 *      ```
 *      Example 1:
 *      	Input: "F?1:T?3:1"
 *      	Output:  3
 *      	
 *      	Explanation:
 *      	Result of the first expression is "False", so the answer of this expression is: T?3:1.
 *      	It is "True", so the answer is 3.
 *      
 *      Example 2:
 *      	Input: "T?2:3"
 *      	Output:  2
 *      	
 *      Example 3:
 *      	Input: "T?T?F:5:3"
 *      	Output:  F
 *      	
 *      	Explanation:
 *      	Just can be divided to : T? (T?F:5) : 3
 *      	So the answer is 'F'。
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/ternary-expression-parser/description
 * @date   2019-07-11 18:38:19
 */
public class L_0887_Ternary_Expression_Parser {


    /**
     * 需要注意? 嵌套的时候，如何寻找对应的 :
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public String parseTernary(String expression) {
            return helper(expression, 0, expression.length()-1);
        }
        
        private String helper(String exp, int i, int j) {
            if (i == j) return exp.substring(i, i+1);
            int c = 0;
            int k = exp.indexOf('?', i);
            for (; k <= j; k++) { 
                if (exp.charAt(k) == '?') c++;
                else if (exp.charAt(k) == ':') c--;
                if (c==0) break;
            }
            if (exp.charAt(i) == 'T') {
                return helper(exp, i+2, k-1);
            } else {
                return helper(exp, k+1, j);
            }
            
        }
    
    }
    
    public static void main(String[] args) {
        // F?1:T?3:1
        // T?T?F:5:3
        
        String expression = "T?T?F:5:3";
        Out.p(new Solution().parseTernary(expression));
        
    }

}
