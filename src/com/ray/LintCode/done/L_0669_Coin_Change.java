package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return `-1`.
 *
 * 用例：
 *      **Example1**
 *      ```
 *      Input: 
 *      [1, 2, 5]
 *      11
 *      Output: 3
 *      Explanation: 11 = 5 + 5 + 1
 *      ```
 *      **Example2**
 *      ```
 *      Input: 
 *      [2]
 *      3
 *      Output: -1
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/coin-change/description
 * @date   2019-07-11 18:35:19
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
        
        Out.p(new Solution());
        
    }

}
