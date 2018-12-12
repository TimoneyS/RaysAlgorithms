package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * 
 * Given an example n=3 , 1+1+1=2+1=1+2=3
 * return 3
 * @author rays1
 *
 */
public class L_0111_Climbing_Stairs {

    static class Solution {
        
        int[] mem;
        
        /**
         * @param n: An integer
         * @return: An integer
         */
        public int climbStairs(int n) {
            if (mem == null) mem = new int[n+1];
            if (n==1 || n==2 || n == 0) return n;
            if (mem[n] == 0)
                mem[n] = climbStairs(n-2) + climbStairs(n-1);
            return mem[n];
        }
        
    }
    
    public static void main(String[] args) {
        Out.p(new Solution().climbStairs(3));
    }

}
