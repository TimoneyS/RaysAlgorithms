package com.ray.leetcode;

import com.ray.io.Out;

/**
 * Best Time to Buy and Sell Stock with Cooldown
 * -----------------------------------------------------------------------------
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
 * 	You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * 	After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 *
 * Example:
 *      Example 1
 *      Input: [1,2,3,0,2]
 *      Output: 3 
 *      Explanation: transactions = [buy, sell, cooldown, buy, sell]
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 * @since   2020-03-11 19:20:43
 */
public class L0309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown {
    /**
     * dp[i] 表示在第 i 天开始，可能的最大获利
     *      如果第 i 天不买入 dp[i] = dp[i+1]
     *      如果第 i 天  买入，那么假设在第 j 天卖出获利就是
     *          p[j] - p[i] + d[j+1]
     *      那买入的最大获利就是所有可能的卖出天数j中，最大获利
     * dp[i] = max {dp[i+1], {p[j] - p[i] + d[j+1]} }
     *
     */
    static class Solution {
        public int maxProfit(int[] prices) {
            int[] dp = new int[prices.length+2];
            for (int i = prices.length-2; i >= 0; i --) {
                for (int j = i+1; j < prices.length; j++) {
                    dp[i] = Math.max(dp[i],  dp[j+2] + prices[j] - prices[i]);
                }
                dp[i] = Math.max(dp[i],  dp[i+1]);
            }
            return dp[0];
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
