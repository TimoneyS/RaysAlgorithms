package com.ray.LintCode.resolved;

import java.util.HashMap;

import com.ray.io.Out;

/**
 * Calculate the a^n % b where a, b and n are all 32bit positive integers.
 * 
 * For 2^31 % 3 = 2
 * For 100^1000 % 1000 = 0
 * @author rays1
 *
 */
public class L_0140_Fast_Power {

    static class Solution {
        
        HashMap<Integer, Integer> cache;
        /**
         * 求 (a ^ n) % b
         */
        public int fastPower(int a, int b, int n) {
            cache = new HashMap<>();
            return power(a, b, n);
        }
        
        private int power(int a, int b, int n) {
            if (n == 0) return 1 % b;
            if (n == 1) return a % b;

            if (!cache.containsKey(n)) {
                long h = fastPower(a, b, n/2);
                h *= h;
                h = h % b;
                if (n % 2 == 1) {
                    h *= (a%b);   
                }
                cache.put(n, (int) (h % b));
            }
            return cache.get(n);
        }
        
    }
    
    public static void main(String[] args) {
        
        int a = 2147483647;
        int b = 1147483647;
        int n = 2147483647;
        
        Out.p(new Solution().fastPower(a, b, n));
        
    }
    
}
