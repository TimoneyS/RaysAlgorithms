package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      Divide two integers **without using multiplication, division and mod operator.**
 *      
 *      If it will overflow(exceeding 32-bit signed integer representation range), return `2147483647`
 *      
 *      The integer division should truncate toward zero.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: dividend = 0, divisor = 1
 *      Output: 0
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input: dividend = 100, divisor = 9
 *      Output: 11
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/divide-two-integers/description
 * @date   2019-07-11 18:32:46
 */
public class L_0414_Divide_Two_Integers {


    /**
     * 
     * 计算 a 除以 b 的步骤如下
     * 
     * 首先利用位操作，确定      b*2^i  < a < b*2^i+1
     *      a = b*2^i + k
     *        = b*2^i + n*b
     *    a/b = 2^i + n
     * n = ( a - b * 2 ^ i) / b 
     * 
     * 因此问题从  a / b 演变为 ( a - b * 2 ^ i) / b
     * 不断重复以上过程，直到 ( a - b * 2 ^ i) < b 时结束计算
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public int divide(int dividend, int divisor) {
            
           if (divisor == 0) return dividend >= 0? Integer.MAX_VALUE : Integer.MIN_VALUE;
           if (dividend == 0) return 0;
           if (dividend == Integer.MIN_VALUE && divisor == -1)  return Integer.MAX_VALUE;
            
            boolean flag = (dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0);
            
            long a = Math.abs((long)dividend);
            long b = Math.abs((long)divisor);
            int result = 0;
            while(a >= b){
                int shift = 0;
                while(a >= (b << shift)){
                    shift++;
                }
                a -= b << (shift - 1);
                result += 1 << (shift - 1);
            }
            
            return (int) (flag ? result : -result);
        }
    
    }
    
    public static void main(String[] args) {
        
        int dividend = -2147483648;
        int divisor  = -1;
        
        Out.p(new Solution().divide(dividend, divisor));
        
    }
}
