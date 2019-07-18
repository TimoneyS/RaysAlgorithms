package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      <p><span style="line-height: 30px;">Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.</span><br></p>
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input the following triangle:
 *      [
 *           [2],
 *          [3,4],
 *         [6,5,7],
 *        [4,1,8,3]
 *      ]
 *      Output: 11
 *      Explanation: The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 *      ```
 *      
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input the following triangle:
 *      [
 *           [2],
 *          [3,2],
 *         [6,5,7],
 *        [4,4,8,1]
 *      ]
 *      Output: 12
 *      Explanation: The minimum path sum from top to bottom is 12 (i.e., 2 + 2 + 7 + 1 = 12).
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/triangle/description
 * @date   2019-07-11 18:30:40
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
