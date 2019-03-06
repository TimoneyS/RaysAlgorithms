package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 给定不同面值的硬币，和一个总价值。计算最少需要多少硬币来得到这个总价值。如果硬币无法构成，则返回-1;
 * @author rays1
 *
 */
public class L_0669_Coin_Change {

    /**
     * 商品无限时的背包问题
     * 
     * dp[i][v] 从第 i 枚硬币开始取构成价值 v，所需的硬币数。
     *      dp[i][v] = min ( dp[i-1][v], dp[i-1][v - k*coins[i]] + k ) (k (1 ~ v/coins[i])
     * 
     * @author rays1
     *
     */
    static class Solution {
        
        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount+1];
            dp[0] = 0;
            
            for (int v = 1; v <= amount; v ++) {
                dp[v] = -1;
                for (int i = 0; i < coins.length; i++) {
                    if (v >= coins[i] && dp[v - coins[i]] != -1) {
                        if (dp[v] == -1 || dp[v] > dp[v - coins[i]] + 1)
                            dp[v] = dp[v - coins[i]] + 1;
                    }
                }
            }
            return dp[amount];
        }
        
    }
    
    public static void main(String[] args) {
        
        int[] coins = {1,2,20,41,30,40,34,43,47,38,26,39,25,42,37,23,28,49,27};
        int amount = 41010;
     
//        int[] coins = {1};
//        int amount = 2;
        
        Out.p(new Solution().coinChange(coins, amount));
        
    }

}
