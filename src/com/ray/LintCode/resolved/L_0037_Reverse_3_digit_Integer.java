package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * Reverse a 3-digit integer.
 * <p>
 * Reverse 123 you will get 321.
 * Reverse 900 you will get 9.
 * @author rays1
 *
 */
public class L_0037_Reverse_3_digit_Integer {
    
    static class Solution {
        /**
         * @param number: A 3-digit number.
         * @return: Reversed number.
         */
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
        
        int num  = 123;
        
        Out.p(new Solution().reverseInteger(num));
        
    }
    
}
