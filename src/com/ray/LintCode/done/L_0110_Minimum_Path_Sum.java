package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      <p><span style="line-height: 30px;">Given a&nbsp;</span><b><i style="line-height: 30px;">m</i><span style="line-height: 30px;">&nbsp;x&nbsp;</span><i style="line-height: 30px;">n</i></b><span style="line-height: 30px;">&nbsp;grid filled with non-negative numbers, find a path from top left to bottom right which&nbsp;</span><i style="line-height: 30px;"><b>minimizes</b></i><span style="line-height: 30px;">&nbsp;the sum of all numbers along its path.</span><br></p>
 *
 * 用例：
 *      ```
 *      Example 1:
 *      	Input:  [[1,3,1],[1,5,1],[4,2,1]]
 *      	Output: 7
 *      	
 *      	Explanation:
 *      	Path is: 1 -> 3 -> 1 -> 1 -> 1
 *      
 *      
 *      Example 2:
 *      	Input:  [[1,3,2]]
 *      	Output: 6
 *      	
 *      	Explanation:  
 *      	Path is: 1 -> 3 -> 2
 *      
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/minimum-path-sum/description
 * @date   2019-07-11 18:30:41
 */
public class L_0110_Minimum_Path_Sum {

    static class Solution {
        /**
         * @param grid: a list of lists of integers
         * @return: An integer, minimizes the sum of all numbers along its path
         */
        public int minPathSum(int[][] grid) {
            
            int h = grid.length;
            int w = grid[0].length;
            
            for (int i = 1; i < h; i++) grid[i][0] += grid[i-1][0];
            for (int i = 1; i < w; i++) grid[0][i] += grid[0][i-1];
            for (int i = 1; i < h; i++)
                for (int j = 1; j < w; j++)
                    grid[i][j] += Math.min(grid[i][j-1], grid[i-1][j]);
            
            return grid[h-1][w-1];
        }
    }
    
    public static void main(String[] args) {
        
        int[][] grid = {
                {1,2},
                {3,4}
        };
        
        Out.p(new Solution().minPathSum(grid));
        
    }

}
