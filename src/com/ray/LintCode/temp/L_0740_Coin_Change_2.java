package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      You are given coins of different denominations and a total amount of money. Write a function to compute the number of combinations that make up that amount. You may assume that you have infinite number of each kind of coin.
 *
 * 用例：
 *      **Example1**
 *      
 *      ```
 *      Input: amount = 10 and coins = [10] 
 *      Output: 1
 *      ```
 *      
 *      **Example2**
 *      
 *      ```
 *      Input: amount = 8 and coins = [2, 3, 8]
 *      Output: 3
 *      Explanation:
 *      there are three ways to make up the amount:
 *      8 = 8
 *      8 = 3 + 3 + 2
 *      8 = 2 + 2 + 2 + 2
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/coin-change-2/description
 * @date   2019-07-11 18:35:58
 */
public class L_0740_Coin_Change_2 {

    /**
     * 设 dp[i][j] 指到 i 为止，可以构成面值 j 的组合数
     * 
     * dp[i][j] = dp[i-1][j] + dp[i][j-v[i]]
     * 
     * dp[i][j] 的组合 包含 dp[i-1][j] 的所有组合
     * dp[i][j] 的组合 包含 dp[i][j-v[i]] 的每个组合加上一个 v[i] 后的组合，
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
        
        Out.p(new Solution());
        
    }

}
