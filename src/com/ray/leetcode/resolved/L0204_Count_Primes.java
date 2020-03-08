package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Count Primes
 * -----------------------------------------------------------------------------
 * Count the number of prime numbers less than a non-negative number, n.
 *
 * Example:
 *      Example 1
 *      Input: 10
 *      Output: 4
 *      Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/count-primes/
 * @since   2020-03-08 23:38:22
 */
public class L0204_Count_Primes {
    static class Solution {
        public int countPrimes(int n) {
            boolean[] mark = new boolean[n];
            int rs = 0;
            for (int i = 2; i < n; i++) {
                if (mark[i]) continue;
                rs ++;
                for (int j = i; j < n; j += i) mark[j] = true;
            }
            return rs;
        }
    }
    
    public static void main(String[] args) {
        int n = 1500000;
        Out.p(new Solution().countPrimes(n));
    }
}
