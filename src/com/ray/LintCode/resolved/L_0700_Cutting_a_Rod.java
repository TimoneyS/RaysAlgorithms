package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 给定长度为 n 的钢条，和一个 每段钢条的价格。
 * 计算将钢条切割后，可以得到的最大价值。
 *
 * 示例
 *      输入
 *          8
 *          [1, 5, 8, 9, 10, 17, 17, 20]
 *          [1, 2, 3, 5,  5,  6,  7,  8]
 *      输出
 *          22
 *          将钢铁切割成 2 和 6
 * @author rays1
 *
 */
public class L_0700_Cutting_a_Rod {

    /**
     * 将钢条左侧切割下长度为i的一段，然后对右侧的钢条进行切割，左侧的钢条则不切割。
     * 则表示最优解的公式为
     *      dp[n] = max{v[i] + dp[n-i]} ( 1 < i <= n)
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public int cutting(int[] prices, int n) {
            if (prices == null || prices.length == 0) return 0;
            
            int[] dp = new int[n+1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= i; j++) {
                    dp[i] = Math.max(dp[i], dp[i-j] + prices[j-1]);
                }
            }
            return dp[n];
        }
        
    }
    
    public static void main(String[] args) {
        
        int[] prices = {};
        int n        = 8;
        
        Out.p(new Solution().cutting(prices, n));
        
    }

}
