package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a positive integer `a`, find the smallest positive integer `b` whose multiplication of each digit equals to `a`.
 *      
 *      If there is no answer or the answer is not fit in 32-bit signed integer, then return 0.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: 48
 *      Output: 68
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input: 15
 *      Output: 35
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/minimum-factorization/description
 * @date   2019-07-11 18:38:09
 */
public class L_0871_Minimum_Factorization {


    static class Solution {
    
        public int smallestFactorization(int a) {
            int res = 0;
            for (int i = 9, base = 1; a != 1 && i != 1; i--) {
                for (; a % i == 0; a /= i) {
                    res += base * i; 
                    base *= 10;
                }
            }
            if (res < 0 || a != 1) {
                return 0;
            }
            return res;
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
