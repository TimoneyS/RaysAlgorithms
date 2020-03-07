package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Best Time to Buy and Sell Stock
 * -----------------------------------------------------------------------------
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * Note that you cannot sell a stock before you buy one.
 *
 * Example:
 *      Example 1
 *      Input: [7,1,5,3,6,4]
 *      Output: 5
 *      Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 *                   Not 7-1 = 6, as selling price needs to be larger than buying price.
 *      Example 2
 *      Input: [7,6,4,3,1]
 *      Output: 0
 *      Explanation: In this case, no transaction is done, i.e. max profit = 0.
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * @since   2020-03-04 22:30:40
 */
public class L0121_Best_Time_to_Buy_and_Sell_Stock {
    /**
     * 计算当天之前的最小股票价格，不断的计算当天价格 - 最小价格
     * 返回所有结果中的最大值
     */
    static class Solution {
        public int maxProfit(int[] prices) {
            int min = Integer.MAX_VALUE, max = 0;
            for (int i = 0; i < prices.length; i++) {
                min = Math.min(min, prices[i]);
                max = Math.max(max, prices[i] - min);
            }
            return max;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
