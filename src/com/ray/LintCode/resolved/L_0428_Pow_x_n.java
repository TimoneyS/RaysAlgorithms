package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 实现 幂函数 pow(x, n)
 *
 * Pow(2.1, 3) = 9.261
 * Pow(0, 1) = 0
 * Pow(1, 0) = 1
 *
 * @author rays1
 *
 */
public class L_0428_Pow_x_n {

    static class Solution {
    
        public double myPow(double x, int n) {
            if (x == 0 || x == 1) return x;
            if (n == 0) return 1;
            
            if (n < 0 ) {
                if (n == -2147483648)
                    n = 2147483647;
                else
                    n = -n;
                double  rs = helper(x, n);
                if (n == -2147483648)
                    rs = rs * n;
                return 1/rs;
            } else {
                return helper(x, n);
            }
        }
        
        double helper(double x, int n) {
            if (n == 0) {
                return 1;
            } else if (n == 1) {
                return x;
            } else {
                int m = n / 2;
                int r = n - m - m;
                double ms = helper(x, m);
                double rs = helper(x, r);
                return ms * ms * rs;
            }
        }
    
    }
    
    public static void main(String[] args) {
        
        double x = 2;
        int n = -2147483648;
        
        Out.p(new Solution().myPow(x, n));
        
    }

}
