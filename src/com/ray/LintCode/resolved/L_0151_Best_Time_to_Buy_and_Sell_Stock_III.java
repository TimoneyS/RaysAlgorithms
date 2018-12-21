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
            int max = 0;
            int secMax = 0;
            int sum = 0;
            for (int i = 1; i < prices.length; i++) {
                int d = prices[i] - prices[i-1];
                sum += d;
                if (sum < 0) sum = 0;
                if (sum >= max) {
                    secMax = max;
                    max = sum;
                }
                max = Math.max(max, sum);
            }
            return max + secMax;
        }
    }
    
    public static void main(String[] args) {
        
        int[] prices = {1,2,4,7};
        Out.p(new Solution().maxProfit(prices));
    }

}
