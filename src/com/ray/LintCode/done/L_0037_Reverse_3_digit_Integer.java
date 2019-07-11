package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      Reverse a 3-digit integer.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: number = 123
 *      Output: 321
 *      ```
 *      **Example 2:**
 *      
 *      ```
 *      Input: number = 900
 *      Output: 9
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Native
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/reverse-3-digit-integer/description
 * @date   2019-07-11 17:48:06
 */
public class L_0037_Reverse_3_digit_Integer {

    static class Solution {
    
        public int reverseInteger(int number) {
            int newNum = 0;
            while (number != 0) {
                newNum *= 10;
                newNum += (number % 10);
                number /= 10;
            }
            return newNum;
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
