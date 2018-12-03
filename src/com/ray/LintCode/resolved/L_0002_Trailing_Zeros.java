package com.ray.LintCode.resolved;

/**
 * Write an algorithm which computes the number of trailing zeros in n factorial.
 * <p>
 * 11! = 39916800, so the out should be 2
 * <p>
 * Challenge : O(log N) time
 * @author rays1
 *
 */
public class L_0002_Trailing_Zeros {
    static class Solution {
        /*
         * @param n: An integer
         * @return: An integer, denote the number of trailing zeros in n!
         */
        public long trailingZeros(long n) {
            // write your code here, try to do it without arithmetic operators.
            int i = (int) ( Math.log(n) / Math.log(5) );
            long sum = 0;
            for (int j=1;j<=i; j++ ) {
                sum = sum + (long) (n / Math.pow(5, j));
            }
            return sum;
        }
    }
}
