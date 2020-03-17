package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Super Pow
 * -----------------------------------------------------------------------------
 * Your task is to calculate ab mod 1337 where a is a positive integer and b is an extremely large positive integer given in the form of an array.
 *
 * Example:
 *      Example 1
 *      Input: a = 2, b = [3]
 *      Output: 8
 *      Example 2
 *      Input: a = 2, b = [1,0]
 *      Output: 1024
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/super-pow/
 * @since   2020-03-17 22:50:52
 */
public class L0372_Super_Pow {
    /**
     * a ^ 1234 = (a ^ 123) ^ 10 * a^3
     */
    static class Solution {
        public int superPow(int a, int[] b) {
            return superPow(a, b, b.length-1);
        }

        private int superPow(int a, int[] b, int i) {
            if (i == 0) return pow(a, b[i]);
            int t1 = pow(a, b[i]);
            int t2 = pow(superPow(a, b, i-1), 10);
            return (t1 * t2) % 1337;
        }

        private int pow(int a, int i) {
            if (i == 1) return a % 1337;
            if (i == 0) return 1;
            int t = pow(a, i / 2);

            if (i % 2 == 0) {

            }
            return i % 2 == 0 ? (t * t) % 1337 : ((t * t )% 1337 * (a % 1337)) % 1337;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
