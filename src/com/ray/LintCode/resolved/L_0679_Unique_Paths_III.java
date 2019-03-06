package com.ray.LintCode.resolved;

import java.util.HashSet;
import java.util.Set;

import com.ray.io.Out;

/**
 * L_0115_Unique_Paths_II 的跟进问题：
 *      现在每一个格子都包含了一个值，所以每条路径都有一个值，所有值唯一的路径的值之和。
 * @author rays1
 * @author https://www.lintcode.com/problem/unique-paths-iii/description
 */
public class L_0679_Unique_Paths_III {

    /**
     * 用 dp[i][j] 表示每个点可能存在的不同的路径值
     *      用 dfs搜索，并记录遍历路径的值，如果搜索到某个点发现当前遍历值已经在dp中
     *      则说明和已经存在的某个路径经过这个点的值相同，则后续一定会有重复路径，则当前路径终止搜索。
     * @author rays1
     *
     */
    static class Solution {
    
        public int uniqueWeightedPaths(int[][] grid) {
            int m = grid == null ? 0 : grid.length, n = m == 0 ? 0 : grid[0].length;
            if (m * n== 0) return 0;
            @SuppressWarnings("unchecked")
            Set<Integer>[][] dp = new HashSet[m][n];
            dfs(grid, 0, 0, 0, dp);
            int rs = 0;
            for (int i : dp[m-1][n-1]) rs += i;
            return rs;
        }

        private void dfs(int[][] grid,int base, int i, int j, Set<Integer>[][] dp) {
            if (i >= grid.length || j >= grid[0].length) return;
            base += grid[i][j];
            if (dp[i][j] == null) dp[i][j] = new HashSet<>();
            if (dp[i][j].contains(base)) return;
            dp[i][j].add(base);
            dfs(grid, base, i+1, j, dp);
            dfs(grid, base, i, j+1, dp);
        }
    
    }
    
    public static void main(String[] args) {
        
        int[][] grid = {
                {1, 1, 2},
                {1, 2, 3},
                {3, 2, 4}
        };
        
        Out.p(new Solution().uniqueWeightedPaths(grid));
        
    }

}
