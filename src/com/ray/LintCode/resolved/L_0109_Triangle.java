package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * <p>
 * Example 
 * [
 *     [2],
 *    [3,4],
 *   [6,5,7],
 *  [4,1,8,3]
 * ]
 * 
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 *
 * @author rays1
 *
 */
public class L_0109_Triangle {

    /**
     * 类似于Dijkstra算法思想
     * @author rays1
     *
     */
    static class Solution {
        /**
         * @param triangle: a list of lists of integers
         * @return: An integer, minimum path sum
         */
        public int minimumTotal(int[][] triangle) {
            int min = triangle[0][0];
            for (int i = 1; i < triangle.length; i++) {
                int n = triangle[i].length;
                triangle[i][0] += triangle[i-1][0];
                triangle[i][n-1] += triangle[i-1][n-2];
                min = Math.min(triangle[i][0], triangle[i][n-1]);
                for (int j = 1; j < n-1; j++) {
                    triangle[i][j] += Math.min(triangle[i-1][j], triangle[i-1][j-1]);
                    min = Math.min(min, triangle[i][j]);
                }
            }
            return min;
        }
    }
    
    public static void main(String[] args) {
        
        int[][] triangle = {
                 {1},
        };
        
        Out.p(new Solution().minimumTotal(triangle));
        
    }
    

}
