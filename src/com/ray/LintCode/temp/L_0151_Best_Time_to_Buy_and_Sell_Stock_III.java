package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      Say you have an array for which the _i_<sup>th</sup> element is the price of a given stock on day _i_.
 *      
 *      Design an algorithm to find the **maximum** profit. You may complete at most _two_ transactions.
 *
 * 用例：
 *      ***Example 1***
 *      ```
 *      Input : [4,4,6,1,1,4,2,5]
 *      Output : 6
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/best-time-to-buy-and-sell-stock-iii/description
 * @date   2019-07-11 18:31:13
 */
public class L_0151_Best_Time_to_Buy_and_Sell_Stock_III {

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
        
        int[] prices = {1,2,1,2,1,2};
        Out.p(new Solution().maxProfit(prices));
    }

}
