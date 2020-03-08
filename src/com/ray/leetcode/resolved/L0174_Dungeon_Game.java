package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.Arrays;

/**
 * Dungeon Game
 * -----------------------------------------------------------------------------
 * 地下城是由 M x N 个房间组成的二维网格。
 * 公主（P）在了地下城的右下角。骑士（K）最初在左上角。
 * 骑士的初始健康点数为一个正整数，健康点数降至 0 或以下，他会立即死亡。
 * 其实需要穿过房间，到达公主所在的格子。若房间里的值为负整数，则表示骑士将损失健康点数；若房间里的值为正整数，则表示骑士将增加健康点数。
 * 为了尽快到达公主，骑士决定每次只向右或向下移动一步。
 *
 * 编写一个函数来计算确保骑士能够拯救到公主所需的最低初始健康点数。
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/dungeon-game/
 * @since   2020-03-08 17:42:29
 */
public class L0174_Dungeon_Game {
    /**
     * 设 dp[i][j] 表示从该格子去公主格子所需的最小健康值。
     * 则 dp[i][j] = min {dp[i+1][j], dp[i][j+1]} - d[i][j]
     *
     * 可以缩减空间到一维
     *      dp[i] = min {dp[i], dp[i+1]} - d[x][i]
     */
    static class Solution {
        public int calculateMinimumHP(int[][] dungeon) {
            int n = dungeon.length, m = dungeon[0].length;
            int[] dp = new int[m+1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[m-1] = 1;
            for (int i = n-1; i >= 0; i --) {
                for (int j = m-1; j >= 0; j--) {
                    int c = Math.min(dp[j], dp[j+1]);
                    if (dungeon[i][j] < 0) {
                        dp[j] = c - dungeon[i][j];
                    } else {
                        dp[j] = Math.max(1, c - dungeon[i][j]);
                    }
                }
            }
            return dp[0];
        }
    }
    
    public static void main(String[] args) {
        int[][] dungeon = {
                {-2,-3,3},
                {-5,-10,1},
                {10,30,-5}
        };
        Out.p(new Solution().calculateMinimumHP(dungeon));
    }
}
