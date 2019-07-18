package com.ray.LintCode.temp;

import java.util.HashSet;
import java.util.Set;

import com.ray.io.Out;

/**
 * 描述：
 *      Follow up for "Unique Paths II": [http://lintcode.com/en/problem/unique-paths-ii/](http://lintcode.com/en/problem/unique-paths-ii/ "http://lintcode.com/en/problem/unique-paths-ii/")
 *      
 *      Now each grid contains a value, so each path also has a value. Find the `sum` of all the `unique values` paths.
 *
 * 用例：
 *      **Example 1**
 *      
 *      ```plain
 *      Input:
 *      [
 *        [1,1,2],
 *        [1,2,3],
 *        [3,2,4]
 *      ]
 *      Output:
 *      21
 *      Explanation:
 *      There are 2 unique value path:
 *      [1,1,2,3,4] = 11
 *      [1,1,2,2,4] = 10
 *      ```
 *      
 *      **Example 2**
 *      
 *      ```plain
 *      Input:
 *      [
 *          [1,5],
 *          [4,6]
 *      ]
 *      Output: 23
 *      Explanation:
 *      There are 2 unique value path:
 *      [1,5,6] = 12
 *      [1,4,6] = 11
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/unique-paths-iii/description
 * @date   2019-07-11 18:35:24
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
        
        Out.p(new Solution());
        
    }

}
