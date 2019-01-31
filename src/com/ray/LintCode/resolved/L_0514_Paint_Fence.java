package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 
 * 一个栅栏有 n 个柱子，每个柱子可以被涂上一种颜色，共有 k 种 颜色
 * 最多只能有两个相邻的柱子涂成相同的颜色， 
 * 
 * 计算栅栏一共可以被涂成多少种颜色
 *
 * @author rays1
 *
 */
public class L_0514_Paint_Fence {

    /**
     * 设 前 i 根柱子有 Si 种涂色的方法
     * 
     * 计算第i个柱子时，有两种情况
     *      1. 该柱子和第 i-1 个柱子颜色相同
     *          
     *          
     *      2. 该柱子和第 i-1 个柱子颜色不同
     *          

     * 
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public int numWays(int n, int k) {
            
            if (n == 1) {
                return k;
            }
            
            int[] mem = new int[n+1];
            
            mem[1] = k;
            mem[2] = k*k;
            for (int i = 3; i <= n; i++) {
                mem[i] = (k-1) * (mem[i-1] + mem[i-2]);
            }

            Out.p(mem);
            
            return mem[n];
        }
    
    }
    
    public static void main(String[] args) {
        
        int n = 2;
        int k = 1;
        
        Out.p(new Solution().numWays(n, k));
        
    }

}
