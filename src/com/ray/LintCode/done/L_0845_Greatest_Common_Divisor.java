package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      Given two numbers, number `a` and number `b`. Find the `greatest common divisor` of the given two numbers.
 *
 * 用例：
 *      **Example1**
 *      
 *      ```
 *      Input: a = 10, b = 15
 *      Output: 5
 *      Explanation:
 *      10 % 5 == 0
 *      15 % 5 == 0
 *      ```
 *      
 *      **Example2**
 *      
 *      ```
 *      Input: a = 15, b = 30
 *      Output: 15
 *      Explanation:
 *      15 % 15 == 0
 *      30 % 15 == 0
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/greatest-common-divisor/description
 * @date   2019-07-11 18:37:28
 */
public class L_0845_Greatest_Common_Divisor {

    static class Solution {
        
        public int gcd(int a, int b) {
            if (a < b) return gcd(b, a);
            if (b == 0) return a;
            return gcd(a%b, b);
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
