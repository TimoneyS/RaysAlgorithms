package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 *Given a positive integer a, find the smallest positive integer b whose multiplication of each digit equals to a.

If there is no answer or the answer is not fit in 32-bit signed integer, then return 0.
 *
 * @author rays1
 * @url    
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
        
        int a = 729;
        Out.p(new Solution().smallestFactorization(a));
        
    }

}
