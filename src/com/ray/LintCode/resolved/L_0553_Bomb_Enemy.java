package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 给定一个二维的方格，每个格子可以是 W 代表墙、 E 代表敌人或者 0 代表空
 * 
 * 计算一个炸弹最多能够炸死多少敌人。
 * 
 * @author rays1
 *
 */
public class L_0553_Bomb_Enemy {

    /**
     * 炸弹落在每个点上能炸死的敌人数量由5个部分构成
     *      1. 向左、向右、向上、向下能炸死的敌人之和
     *      2. 落点正好是否有敌人
     * 
     * 用四个数组 l, r, u, d分别保存每个点向左、向右、向上、向下能够炸死的敌人
     * 则每个点能够炸死的敌人数量为  l[p] + r[p] + u[p] + d[p] + enemy(p)
     * 
     * 一个坑爹的点在于，实际上题目要求只有空地能够落下炸弹
     * 复杂度  O(mn)
     * @author rays1
     *
     */
    static class Solution {
        
        static final char W = 'W';
        static final char E = 'E';
        static final char BLANK = '0';
    
        public int maxKilledEnemies(char[][] grid) {
            
            int m, n;
            
            try {
                m = grid.length;
                n = grid[0].length;
            } catch (Exception e) {
                return 0;
            }
            
            int[][] l = new int[m][n], r = new int[m][n], u = new int[m][n], d = new int[m][n];
            
            // 计算向左能够炸死的敌人数目
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (j == 0 || grid[i][j-1] == W) l[i][j] = 0;
                    else                             l[i][j] = grid[i][j-1] == E ? l[i][j-1] + 1 : l[i][j-1];
                }
            }
            
            // 计算向右能够炸死的敌人数目
            for (int i = 0; i < m; i++) {
                for (int j = n-1; j >= 0; j--) {
                    if (j == n-1 || grid[i][j+1] == W) r[i][j] = 0;
                    else                               r[i][j] = grid[i][j+1] == E ? r[i][j+1] + 1 : r[i][j+1];
                }
            }
            
            // 计算向上能够炸死的敌人数目
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0 || grid[i-1][j] == W) u[i][j] = 0;
                    else                             u[i][j] = grid[i-1][j] == E ? u[i-1][j] + 1 : u[i-1][j];
                }
            }
            
            // 计算向下能够炸死的敌人数目
            for (int i = m-1; i >= 0; i--) {
                for (int j = 0; j < n; j++) {
                    if (i == m-1 || grid[i+1][j] == W) d[i][j] = 0;
                    else                               d[i][j] = grid[i+1][j] == E ? d[i+1][j] + 1 : d[i+1][j];
                }
            }
            
            int max = 0;
            
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] != '0') continue;
                    int sum = l[i][j] + r[i][j] + u[i][j] + d[i][j]; 
                    if (grid[i][j] == E) sum += 1;
                    max = Math.max(max, sum);
                }
            }
            
            return max;
        }
    
    }
    
    public static void main(String[] args) {
        char[][] grid = {
                {'0', 'E', '0', '0'},
                {'E', '0', 'W', 'E'},
                {'0', 'E', '0', '0'},
        };
        
        Out.p(new Solution().maxKilledEnemies(grid));
        
    }

}
