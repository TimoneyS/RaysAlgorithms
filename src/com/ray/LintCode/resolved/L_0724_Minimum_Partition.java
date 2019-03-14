package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 给定一个集合的正数，编写方法将其划分位两个集合 S1 和 S2，两个集合的绝对差异最小。
 * 如果集合 S 有 n 个元素，假设 S1 有 m 个元素，S2有 n-m 个元素，并且 abs(sum(Subset1) – sum(Subset2)) 最小。
 * @author rays1
 * @url    https://www.lintcode.com/problem/minimum-partition/description
 *
 */
public class L_0724_Minimum_Partition {

    /**
     * 假设存在两个集合的和分别是 sum1, sum2 (sum1 <= sum 2)其绝对差异最小，设全部集合之和为 2m，则
     *      sum1 + sum2 = 2m
     *      m - sum1 = sum2 - m >= 0
     * 推论：不存在任意的 sumx1 < m 使得 m - sumx1 < m - sum1     
     * 证明：
     *      假设存在，则
     *          m - sumx1 < m - sum1
     *          2m - sumx1 < 2m - sum1
     *      存在 
     *          sumx2 - m = m - sumx1
     *      则
     *          2m = sumx1 + sumx2
     *          2m = sum1 + sum2
     *      带入不等式
     *          sumx2 - sumx1 < sum2 - sum1
     *      和 sum1 sum2 是绝对差异最小矛盾。
     * 因此
     *      sum1 是集合中能够组成的 小于 m 的最大值。     
     *      
     *      这样问题可以转换为背包问题，在 集合构成了商品价值，用大小为 m 的背包，找到最大价值。
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        
        /**
         * dp[i][m] 剩余 m，到商品 i 的最大值
         * 
         *      dp[i][m] = max(dp[i][m-v[i]] + v[i], dp[i-1][m] )
         * 
         * @param nums
         * @return
         */
        public int findMin(int[] nums) {
            int m = 0;
            for (int num : nums) m += num;
            
            int[] dp = new int[(m>>1)+1];
            for (int i = 0; i < nums.length; i++) {
                for (int j = dp.length-1; j > 0; j--) {
                    if (j < nums[i]) break;
                    dp[j] = Math.max(dp[j], dp[j-nums[i]]+nums[i]);
                }
            }
            return Math.abs(m - (dp[dp.length-1] << 1));
        }
        
        int helper(int i, int c, int[] nums, int[][] dp) {
            if (i >= nums.length || c < 0) return 0;
            if (dp[i][c] == 0) {
                int v1 = c >= nums[i] ? helper(i+1, c-nums[i], nums, dp)+nums[i] : 0;
                int v2 = helper(i+1, c, nums, dp);
                dp[i][c] = Math.max(v1, v2);
            }
            return dp[i][c];
        }
    
    }
    
    public static void main(String[] args) {
        
        int[] nums = {1, 6, 11, 5};
        
        Out.p(new Solution().findMin(nums));
        
    }

}
