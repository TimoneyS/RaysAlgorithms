package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.HashSet;
import java.util.Set;

/**
 * Happy Number
 * -----------------------------------------------------------------------------
 * Write an algorithm to determine if a number is happy.
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 *
 * Example:
 *      Example 1
 *      Input: 19
 *      Output: true
 *      Explanation: 
 *      12 + 92 = 82
 *      82 + 22 = 68
 *      62 + 82 = 100
 *      12 + 02 + 02 = 1
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/happy-number/
 * @since   2020-03-08 23:29:06
 */
public class L0202_Happy_Number {
    static class Solution {
        public boolean isHappy(int n) {
            Set<Integer> cache = new HashSet<>();
            while (n != 1) {
                if (cache.contains(n = trans(n))) return false;
                cache.add(n);
            }
            return true;
        }

        private int trans(int n) {
            int num = 0;
            while (n > 0) {
                num += Math.pow((n%10), 2);
                n /= 10;
            }
            return num;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
