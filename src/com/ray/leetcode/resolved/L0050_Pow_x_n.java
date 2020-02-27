package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Pow(x, n)
 *
 * Implement pow(x, n), which calculates x raised to the power n (xn).
 *
 * Example:
 *      Example 1
 *      Input: 2.00000, 10
 *      Output: 1024.00000
 *      Example 2
 *      Input: 2.10000, 3
 *      Output: 9.26100
 *      Example 3
 *      Input: 2.00000, -2
 *      Output: 0.25000
 *      Explanation: 2-2 = 1/22 = 1/4 = 0.25
 *      Note:
 *      	-100.0 &lt; x &lt; 100.0
 *      	n is a 32-bit signed integer, within the range [&minus;231, 231 &minus; 1]
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/powx-n/
 * @since   2020-02-27 22:19:25
 */
public class L0050_Pow_x_n {
    static class Solution {
        public double myPow(double x, int n) {
            if (x == 0 || x == 1) return x;
            if (n == 0) return 1;

            if (n < 0 ) {
                double  rs;
                if (n == -2147483648) {
                    rs = helper(x, 2147483647) * x;
                } else {
                    rs = helper(x, -n);
                }
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
        Out.p(new Solution());
    }
}
