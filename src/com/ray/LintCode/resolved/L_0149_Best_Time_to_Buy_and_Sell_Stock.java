package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 数组中保存股票每天的价格，只能做一笔交易，寻找最大利润。
 *
 * Given array [3,2,3,1,2], return 1.
 * 
 * @author rays1
 *
 */
public class L_0149_Best_Time_to_Buy_and_Sell_Stock {

    /**
     * 分别计算
     *      在第i天以及之前前卖出的最大利润  maxProfitSellAt
     *      在第i天以及之后买入的最大利润     maxProfitBuyAt
     * 然后遍历两个数组，寻找最大的 maxProfitSellAt[i]+ maxProfitBuyAt[i]
     * @author rays1
     *
     */
    static class Solution {
        
        /**
         * 
         * 最大利润 = Max {正利润总和}
         * 
         * @param prices
         * @return
         */
        public int maxProfit(int[] prices) {
  
            int[] maxProfitSellBefore = new int[prices.length];
            int[] maxProfitBuyAfter = new int[prices.length];
            
            int sum = 0;
            for (int i = 1; i < prices.length; i++) {
                sum += prices[i] - prices[i-1];
                if (sum < 0) sum = 0;
                maxProfitSellBefore[i] = Math.max(maxProfitSellBefore[i-1], sum);
            }
            
            sum = 0;
            for (int i = prices.length - 2; i >= 0; i--) {
                sum += prices[i+1] - prices[i];
                if (sum < 0) sum = 0;
                maxProfitBuyAfter[i] = Math.max(maxProfitBuyAfter[i+1], sum);
            }
            
            int max = 0;
            for (int i = 0; i < maxProfitBuyAfter.length; i++) {
                max = Math.max(max, maxProfitBuyAfter[i] + maxProfitSellBefore[i]);
            }
            
            return max;
        }
    }
    
    public static void main(String[] args) {
        
        int[] prices = {4,4,6,1,1,4,2,5};
        Out.p(new Solution().maxProfit(prices));
    }

}
