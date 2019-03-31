package com.ray.LintCode.resolved;

/**
 * Write an algorithm which computes the number of trailing zeros in n factorial.
 * <p>
 * 11! = 39916800, so the out should be 2
 * <p>
 * Challenge : O(log N) time
 * @author rays1
 * @url    https://www.lintcode.com/problem/trailing-zeros/description
 * 
 */
public class L_0002_Trailing_Zeros {
    
    /**
     * 统计 1 ~ n 的数字中，最终每个数字可以分解为多少个 5 相乘
     * @author rays1
     *
     */
    static class Solution {
        
        public long trailingZeros(long n) {
            long sum = 0;
            while (n != 0) {
                sum += n / 5;
                n /= 5;
            }
            return sum;
        }
        
    }
    
}
