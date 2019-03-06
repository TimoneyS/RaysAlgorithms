package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 一个机器人位于 mxn 的矩阵的左上角，只能向右或者向下移动。
 * 现在机器人要到矩阵的右下角，一共有多少条可能的路径。
 * 
 * @author rays1
 *
 */
public class L_0114_Unique_Paths {

    
    /**
     * 设 dp[i][j] 表示机器人到达 位置[i, j] 有多少种可能。
     * 因为机器人只能向右或者向下，那么如果要到达位置 [i, j]，只可能是从 [i-1, j] 或者 [i, j-1] 而来
     * 所以
     *      dp[i][j] = dp[i-1][j] + dp[i][j-1];
     * 
     * @author rays1
     *
     */
    static class Solution {
        
        public int uniquePaths(int h, int w) {
            int[] dp = new int[w];
            
            for (int i = 0; i < w; i++)
                dp[i] = 1;
            
            for (int i = 1; i < h; i++) 
                for (int j = 1; j < w; j++)
                    dp[j] += dp[j-1];
            
            return dp[w-1];
        }
        
    }
    
    public static void main(String[] args) {
        int h = 3;
        int w = 3;
        
        Out.p(new Solution().uniquePaths(h, w));
    }

}
