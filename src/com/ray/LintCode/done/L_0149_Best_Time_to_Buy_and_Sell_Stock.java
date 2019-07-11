package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      Say you have an array for which the *i*<sup>th</sup> element is the price of a given stock on day *i*.
 *      
 *      If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 *
 * 用例：
 *      **Example 1**
 *      
 *      ```plain
 *      Input: [3, 2, 3, 1, 2]
 *      Output: 1
 *      Explanation: You can buy at the third day and then sell it at the 4th day. The profit is 2 - 1 = 1
 *      ```
 *      
 *      **Example 2**
 *      
 *      ```plain
 *      Input: [1, 2, 3, 4, 5]
 *      Output: 4
 *      Explanation: You can buy at the 0th day and then sell it at the 4th day. The profit is 5 - 1 = 4
 *      ```
 *      
 *      **Example 3**
 *      
 *      ```plain
 *      Input: [5, 4, 3, 2, 1]
 *      Output: 0
 *      Explanation: You can do nothing and get nothing.
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/best-time-to-buy-and-sell-stock/description
 * @date   2019-07-11 18:31:11
 */
public class L_0149_Best_Time_to_Buy_and_Sell_Stock {

    /**
     * 计算当天之前的最小股票价格，不断的计算当天价格 - 最小价格
     * 返回所有结果中的最大值
     * @author rays1
     *
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
        
        int[] prices = {4,4,6,1,1,4,2,5};
        Out.p(new Solution().maxProfit(prices));
    }

}
