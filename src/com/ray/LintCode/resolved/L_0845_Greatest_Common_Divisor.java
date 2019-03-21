package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 *
 * Given two numbers, number a and number b. Find the greatest common divisor of the given two numbers.
 *
 * @author rays1
 *
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
