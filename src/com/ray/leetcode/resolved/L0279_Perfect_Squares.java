package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.HashMap;
import java.util.Map;

/**
 * Perfect Squares
 * -----------------------------------------------------------------------------
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 *
 * Example:
 *      Example 1
 *      Input: n = 12
 *      Output: 3 
 *      Explanation: 12 = 4 + 4 + 4.
 *      Example 2
 *      Input: n = 13
 *      Output: 2
 *      Explanation: 13 = 4 + 9.
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/perfect-squares/
 * @since   2020-03-10 01:38:06
 */
public class L0279_Perfect_Squares {
    static class Solution {

        Map<Integer, Integer> mem;

        public int numSquares(int n) {
            mem = new HashMap<>();
            return helper(n);
        }

        int helper(int n) {
            if (n == 0) return 0;
            if (n == 1) return 1;
            if (!mem.containsKey(n)) {
                int min = Integer.MAX_VALUE;
                for (int i = (int) Math.sqrt(n); i >= (int) Math.sqrt(n/2); i --) {
                    min = Math.min(min, helper(n - i*i));
                }
                mem.put(n, 1 + min);
            }
            return mem.get(n);
        }
    }
    
    public static void main(String[] args) {
        int n = 192001;
        Out.p(new Solution().numSquares(n));
    }
}
