package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Best Time to Buy and Sell Stock III
 * -----------------------------------------------------------------------------
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 *
 * Example:
 *      Example 1
 *      Input: [3,3,5,0,0,3,1,4]
 *      Output: 6
 *      Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 *                   Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
 *      Example 2
 *      Input: [1,2,3,4,5]
 *      Output: 4
 *      Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 *                   Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 *                   engaging multiple transactions at the same time. You must sell before buying again.
 *      Example 3
 *      Input: [7,6,4,3,1]
 *      Output: 0
 *      Explanation: In this case, no transaction is done, i.e. max profit = 0.
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
 * @since   2020-03-04 22:33:04
 */
public class L0123_Best_Time_to_Buy_and_Sell_Stock_III {
    static class Solution {

        public int maxProfit(int[] prices) {

            // 在第 i 天前卖出的最大利润
            int[] maxProfitSellAt = new int[prices.length];
            // 在第 i 天前卖出的最大利润
            int[] maxProfitBuyAt  = new int[prices.length];

            int sum = 0;
            for (int i = 1; i < prices.length; i++) {
                sum += prices[i] - prices[i-1];
                if (sum < 0) sum = 0;
                maxProfitSellAt[i] = Math.max(maxProfitSellAt[i-1], sum);
            }

            sum = 0;
            for (int i = prices.length - 2; i >= 0; i--) {
                sum += prices[i+1] - prices[i];
                if (sum < 0) sum = 0;
                maxProfitBuyAt[i] = Math.max(maxProfitBuyAt[i+1], sum);
            }

            int max = 0;
            for (int i = 0; i < maxProfitBuyAt.length; i++) {
                max = Math.max(max, maxProfitBuyAt[i] + maxProfitSellAt[i]);
            }

            return max;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
