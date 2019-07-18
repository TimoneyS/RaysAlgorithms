package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      In material plane "reality", there are `n + 1` planets, namely planet 0, planet 1, ..., planet n.
 *      Each planet has a portal through which we can reach the target planet directly without passing through other planets.
 *      But portal has two shortcomings.
 *      First, planet `i` can only reach the planet whose number is **greater than** `i`, and the difference between `i` can not exceed the limit.
 *      Second,  it takes `cost[j]` gold coins to reach the planet `j` through the portal.
 *      Now, Rogue Knight Sven arrives at the planet `0` with `m` gold coins, how many ways does he reach the planet `n` through the portal?
 *
 * 用例：
 *      Example 1:
 *      ```
 *      Input:
 *      n = 1
 *      m = 1
 *      limit = 1
 *      cost = [0, 1]
 *      Output:
 *      1
 *      Explanation:
 *      Plan 1: planet 0 → planet 1
 *      ```
 *      
 *      Example 2:
 *      ```
 *      Input:
 *      n = 1
 *      m = 1
 *      limit = 1
 *      cost = [0,2]
 *      Output:
 *      0
 *      Explanation:
 *      He can not reach the target planet.
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/rogue-knight-sven/description
 * @date   2019-07-11 18:36:04
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
