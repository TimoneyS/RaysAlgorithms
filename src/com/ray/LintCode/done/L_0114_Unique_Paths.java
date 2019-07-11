package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      A robot is located at the top-left corner of a *m* x *n* grid.
 *      
 *      The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid.
 *      
 *      How many possible unique paths are there?
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: n = 1, m = 3
 *      Output: 1	
 *      Explanation: Only one path to target position.
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input:  n = 3, m = 3
 *      Output: 6	
 *      Explanation:
 *      	D : Down
 *      	R : Right
 *      	1) DDRR
 *      	2) DRDR
 *      	3) DRRD
 *      	4) RRDD
 *      	5) RDRD
 *      	6) RDDR
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/unique-paths/description
 * @date   2019-07-11 18:30:43
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
