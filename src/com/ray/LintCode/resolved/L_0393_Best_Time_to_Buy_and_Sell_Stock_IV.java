package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 假设您有一个数组，其中第 i 个元素是第 i 天给定股票的价格。设计算法以找到最大利润。
 * 
 * 您最多可以完成k笔交易。
 *
 * 如 [4,4,6,1,1,4,2,5]  k = 2 返回 6
 * 
 * 时间复杂度 O(nk)
 * @author rays1
 *
 */
public class L_0393_Best_Time_to_Buy_and_Sell_Stock_IV {

    /**
     *   local[i][j] 表示在第 i 天，最多 j 笔交易且在第 i 日卖出，所能获得的最大利润
     *  global[i][j] 表示在第 i 天，最多 j 笔交易，所能获得的最大利润
     *  
     *  到了第i+1天，该天的价格和前一天的价格差 为 dp
     *  因为 local 表示必须在今天卖出
     *      local[i][j] = max { global[i - 1][j - 1], local[i][j] } + dp; 表示新增一笔以交和替换上一次交易的最大值
     *     global[i][j] = max { global[i-1][j], local[i][j]};             表示当天不做交易和当天做交易的最大值
     * @author rays1
     *
     */
    static class Solution {
        
        public int maxProfit(int K, int[] P) {
            int m = P.length;
            if (K > m/2) return maxProfix2(P);
            
            int[][] local = new int[m][K+1];
            int[][] global = new int[m][K+1];            
            
            for (int i = 1; i < m; i++) {
                int diff = P[i] - P[i-1];
                for (int j = 1; j <= K; j++) {
                    local[i][j] = Math.max(
                            global[i - 1][j - 1] + Math.max(diff, 0),
                            local[i - 1][j] + diff);
                    global[i][j] = Math.max(global[i - 1][j], local[i][j]);
                }
            }
            
            return global[m-1][K];
        }
        
        public int maxProfix2(int[] P) {
            int rs = 0;
            for (int i = 1; i < P.length; i++) rs += Math.max(P[i] - P[i-1], 0);
            return rs;
        }
        
    }

    public static void main(String[] args) {

        int[] prices = {4, 4, 6, 1, 1, 4, 2, 5};
        int K = 1;
        
        Out.p(new Solution().maxProfit(K, prices));

    }

}
