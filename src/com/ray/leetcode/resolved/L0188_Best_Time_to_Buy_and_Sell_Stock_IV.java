package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Best Time to Buy and Sell Stock IV
 * -----------------------------------------------------------------------------
 * Say you have an array for which the i-th element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most k transactions.
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * <p>
 * Example:
 * Example 1
 * Input: [2,4,1], k = 2
 * Output: 2
 * Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
 * Example 2
 * Input: [3,2,6,5,0,3], k = 2
 * Output: 7
 * Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4.
 * Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 * <p>
 * Level : Hard
 *
 * @author ray
 * @link https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/
 * @since 2020-03-08 20:31:48
 */
public class L0188_Best_Time_to_Buy_and_Sell_Stock_IV {
    /**
     * local[i][j] 表示在第 i 天，最多 j 笔交易且在第 i 日卖出，所能获得的最大利润
     * global[i][j] 表示在第 i 天，最多 j 笔交易，所能获得的最大利润
     * <p>
     * 到了第i+1天，该天的价格和前一天的价格差 为 dp
     * 因为 local 表示必须在今天卖出
     * local[i][j] = max { global[i - 1][j - 1], local[i][j] } + dp; 表示新增一笔以交和替换上一次交易的最大值
     * global[i][j] = max { global[i-1][j], local[i][j]};             表示当天不做交易和当天做交易的最大值
     */
    static class Solution {
        public int maxProfit(int K, int[] P) {
            int m = P.length;
            if (K > m / 2) return maxProfix2(P);

            int[][] local = new int[m][K + 1];
            int[][] global = new int[m][K + 1];

            for (int i = 1; i < m; i++) {
                int diff = P[i] - P[i - 1];
                for (int j = 1; j <= K; j++) {
                    local[i][j] = Math.max(
                            global[i - 1][j - 1] + Math.max(diff, 0),
                            local[i - 1][j] + diff);
                    global[i][j] = Math.max(global[i - 1][j], local[i][j]);
                }
            }

            return global[m - 1][K];
        }

        int maxProfix2(int[] P) {
            int rs = 0;
            for (int i = 1; i < P.length; i++) rs += Math.max(P[i] - P[i - 1], 0);
            return rs;
        }

    }

    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
