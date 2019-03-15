package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 在物质位面“现实”中，有n+1个星球，分别为星球0，星球1，……，星球n。
 * 每一个星球都有一个传送门，通过传送门可以直接到达目标星球而不经过其他的星球。
 * 不过传送门有两个缺点。
 *      1. 从星球i通过传送门只能到达编号比i大，且与i的差不超过limit的星球。
 *      2. 通过传送门到达星球j，需要cost[j]个金币。
 * 现在，流浪剑客斯温到达星球0后身上有m个金币，请问他有多少种方法通过传送门到达星球 n
 *
 * @author rays1
 *
 */
public class L_0752_Rogue_Knight_Sven {

    /**
     * dp[i][j] 到达 i 后 剩余金钱为 j 的方法总数
     *      dp[i][j] = dp[i-1][j+cost[i]] + dp[i-2][j+cost[i]] ..
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public long getNumberOfWays(int n, int m, int limit, int[] cost) {
            long[][] dp = new long[n + 1][m + 1];
            for (int i = 0; i < m; i++) {
                dp[0][i] = 0;
            }
            dp[0][m] = 1;
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j <= m; j++) {
                    dp[i][j] = 0;
                    for (int t = Math.max(0, i - limit); t <= i - 1; t++) {
                        if (j + cost[i] <= m) {
                            dp[i][j] += dp[t][j + cost[i]];
                        }
                    }
                }
            }
            long ans = 0;
            for (int i = 0; i <= m; i++) {
                ans += dp[n][i];
            }
            return ans;
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
