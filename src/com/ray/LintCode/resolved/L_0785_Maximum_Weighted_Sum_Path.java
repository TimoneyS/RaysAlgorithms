package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 一个机器人位于 mxn 的方格的 右上方
 * 机器人只能向下或者向左移动，然后向左下方前进。每到达不同格子有不同的分数，机器人要得到最大的分数。
 * 求机器人能够得到的最大分数。
 * m n 在 200 以内，每个数字在 10000 以内。
 * @author rays1
 *
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
