package com.ray.LintCode.resolved;

/**
 * Count the number of k's between 0 and n. k can be 0 - 9.
 * 
 * if n = 12, k = 1 in
 * [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]
 * we have FIVE 1's (1, 10, 11, 12)
 * @author rays1
 *
 */
public class L_0003_Digit_Counts {
    
    static class Solution {
        
        public int digitCounts(int k, int n) {
            int sum = 0;
            for (int i = 0; i <= n;  i ++)
                sum += count(i, k);
            return sum;
        }
        
        public int count(int n, int k) {
            if (k == 0 && k == n) return 1;
            int sum = 0;
            while (n != 0) {
                if (n%10 == k) sum ++;
                n /= 10;
            }
            return sum;
        }
        
    }
    
}
