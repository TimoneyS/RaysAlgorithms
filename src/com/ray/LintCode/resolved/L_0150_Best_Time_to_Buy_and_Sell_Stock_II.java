package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 数组中保存股票每天的价格，可以做多笔交易，寻找最大利润。
 * 
 * [2,1,2,0,1], return 2
 * 
 * @author rays1
 *
 */
public class L_0150_Best_Time_to_Buy_and_Sell_Stock_II {

    static class Solution {
        public int maxProfit(int[] prices) {
            
            int max = 0;
            int sum = 0;
            for (int i = 1; i < prices.length; i++) {
                int d = prices[i] - prices[i-1];
                sum += d;
                if (sum > 0) {
                    max += sum;
                }
                sum = 0;
            }
            
            return max;
        }
    }
    
    public static void main(String[] args) {
        int[] prices = {3,2,6,5,0,3};
        Out.p(new Solution().maxProfit(prices));
    }

}
