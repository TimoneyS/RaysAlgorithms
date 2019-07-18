package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      Given an array `prices`, which represents the price of a stock in each day.
 *      
 *      You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, if you already have the stock, you must sell it before you buy again).
 *      
 *      Design an algorithm to find the maximum profit.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: [2, 1, 2, 0, 1]
 *      Output: 2
 *      Explanation: 
 *          1. Buy the stock on the second day at 1, and sell the stock on the third day at 2. Profit is 1.
 *          2. Buy the stock on the 4th day at 1, and sell the stock on the 5th day at 2. Profit is 1.
 *          Total profit is 2.
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input: [4, 3, 2, 1]
 *      Output: 0
 *      Explanation: No transaction, profit is 0.
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/best-time-to-buy-and-sell-stock-ii/description
 * @date   2019-07-11 18:31:12
 */
public class L_0150_Best_Time_to_Buy_and_Sell_Stock_II {

    /**
     * 保存每一段上升的折线的 dy
     */
    static class Solution {
        public int maxProfit(int[] prices) {
            int sum = 0;
            for (int i = 1; i < prices.length; i++) {
                int dy = prices[i] - prices[i-1];
                if (dy > 0) sum += dy;
            }
            return sum;
        }
    }
    
    public static void main(String[] args) {
        int[] prices = {3,2,6,5,0,3};
        Out.p(new Solution().maxProfit(prices));
    }

}
