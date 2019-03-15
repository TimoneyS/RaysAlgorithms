package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 给定不同面值的硬币和一个总面值，计算可以构成指定面额的组合数
 * 每种硬币的数量无限。
 * @author rays1
 *
 */
public class L_0740_Coin_Change_2 {

    /**
     * 设 dp[i][j] 指到 i 为止，可以构成面值 j 的组合数
     * 
     * dp[i][j] = dp[i-1][j] + dp[i][j-v[i]]
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public int change(int m, int[] v) {
            int n = v.length;
            int[] dp = new int[m+1];
            dp[0] = 1;
            for (int i = 0; i < n; i++) {
                for (int j = 1; j <= m; j++) {
                    dp[j] += v[i] <= j ? dp[j-v[i]] : 0;
                }
            }
            return dp[m];
        }
    
    }
    
    public static void main(String[] args) {
        
        int m = 7;
        int[] v = {2, 3, 8};
        
        Out.p(new Solution().change(m, v));
        
    }

}
