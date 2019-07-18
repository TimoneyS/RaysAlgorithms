package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a string of numbers, write a function to find the maximum value from the string, you can add a `+` or `*` sign between any two numbers.
 *
 * 用例：
 *      **Example1**
 *      
 *      ```
 *      Input:  str = "01231"
 *      Output: 10
 *      Explanation: 
 *      ((((0 + 1) + 2) * 3) + 1) = 10 we get the maximum value 10
 *      ```
 *      
 *      **Example2**
 *      
 *      ```
 *      Input:  str = "891"
 *      Output: 73
 *      Explanation: 
 *      As 8 * 9 * 1 = 72 and 8 * 9 + 1 = 73 so 73 is maximum.
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/calculate-maximum-value/description
 * @date   2019-07-11 18:35:45
 */
public class L_0719_Calculate_Maximum_Value {

    static class Solution {
        
        public int calcMaxValue(String str) {
            int rs = 0;
            for (int i = 0; i < str.length(); i++) {
                int n = str.charAt(i) - '0';
                rs = Math.max(rs * n, rs + n);
            }
            return rs;
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
