package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 给一整数 n, 我们需要求前n个自然数形成的集合的所有可能子集中所有元素的和。
 *
 * @author rays1
 *
 */
public class L_0730_Sum_of_All_Subsets {

    /**
     * 观察规律即可
     * 
     * n 个数的排列组合 =  n-1 个数的排列组合 + n-1 个数的每个排列组合中加入 n + 单独一个n构成的组合
     * n 个数的排列组合之和 = n-1 个数的排列组合之和 + n-1 个数的排列组合之和 + n-1的排列组合数 * n + n
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public int subSum(int n) {
            
            int[] count = new int[n];
            int[] sum   = new int[n];
            
            count[0] = 1;
            sum[0] = 1;
            
            for (int i = 1; i < n; i++) {
                count[i] = count[i-1] * 2 + 1;
                sum[i]   = sum[i-1]*2 + count[i-1] * (i+1) + i+1;
            }
            
            return sum[n-1];
        }
    
    }
    
    public static void main(String[] args) {
        int n = 3;
        Out.p(new Solution().subSum(n));
        
    }

}
