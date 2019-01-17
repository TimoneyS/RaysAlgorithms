package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 数组中保存股票每天的价格，只能做一笔交易，寻找最大利润。
 *
 * [3,2,3,1,2] 返回 1
 * 
 * @author rays1
 *
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
