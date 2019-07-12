package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      A robot is located at the top-right corner of a `m x n` grid.
 *      The robot can only move either down or left at any point in time. The robot is trying to reach the bottom-left corner of the grid.Every grid has a number,the robot wants to get the **max** weighted sum path.
 *      What is the maximum weighted sum path?
 *
 * 用例：
 *      Example 1:
 *      ```
 *      Input:
 *      [
 *      [1,2,3,4],
 *      [3,5,6,7],
 *      [9,10,1,2],
 *      [4,4,5,5]
 *      ]
 *      Output: 45.
 *      Explanation:
 *      The path is [4,7,6,5,10,9,4].
 *      ```
 *      Example 2:
 *      ```
 *      Input:
 *      [
 *      [1,2,3],
 *      [4,5,6],
 *      [7,9,8]
 *      ]
 *      Output:33.
 *      Explanation:
 *      The path is [3,6,8,9,7].
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/maximum-weighted-sum-path/description
 * @date   2019-07-11 18:36:42
 */
public class L_0785_Maximum_Weighted_Sum_Path {

    /**
     * dp[i][j] 到达 i，j 的最大分数
     * 
     * dp[i][j] = max { dp[i-1][j], dp[i-1][j+1] }
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public int maxWeight(int[][] nums) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = nums[0].length-1; j >= 0; j--) {
                    int n1 = i > 0 ? nums[i-1][j] : 0;
                    int n2 = j < nums[0].length-1 ? nums[i][j+1] : 0;
                    nums[i][j] += Math.max(n1, n2); 
                }
            }
            return nums[nums.length-1][0];
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
