package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Climbing Stairs
 *
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * Note: Given n will be a positive integer.
 *
 * Example:
 *      Example 1
 *      Input: 2
 *      Output: 2
 *      Explanation: There are two ways to climb to the top.
 *      1. 1 step + 1 step
 *      2. 2 steps
 *      Example 2
 *      Input: 3
 *      Output: 3
 *      Explanation: There are three ways to climb to the top.
 *      1. 1 step + 1 step + 1 step
 *      2. 1 step + 2 steps
 *      3. 2 steps + 1 step
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/climbing-stairs/
 * @since   2020-02-28 22:55:41
 */
public class L0070_Climbing_Stairs {
    static class Solution {
        int[] mem;
        public int climbStairs(int n) {
            if (mem == null) mem = new int[n+1];
            if (n==1 || n==2 || n == 0) return n;
            if (mem[n] == 0)
                mem[n] = climbStairs(n-2) + climbStairs(n-1);
            return mem[n];
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
