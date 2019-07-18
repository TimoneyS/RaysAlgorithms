package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      Implement pow(x, n). (n is an integer.)
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: x = 9.88023, n = 3
 *      Output: 964.498
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input: x = 2.1, n = 3
 *      Output: 9.261
 *      ```
 *      
 *      **Example 3:**
 *      
 *      ```
 *      Input: x = 1, n = 0
 *      Output: 1
 *      ```
 *
 * 挑战：
 *      O(*logn*) time
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/powx-n/description
 * @date   2019-07-11 18:33:03
 */
public class L_0428_Powx_n {

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
