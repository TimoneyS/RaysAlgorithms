package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 数组中保存股票每天的价格，最多两笔交易，寻找最大利润。
 *
 * Given an example [4,4,6,1,1,4,2,5], return 6.
 *
 * @author rays1
 *
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
