package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 数组中保存股票每天的价格，可以做多笔交易，寻找最大利润。
 * 
 * [2,1,2,0,1] 2
 * 
 * @author rays1
 *
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
