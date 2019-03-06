package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 给定一个正整数数组。A 从数组的任意一端选择一个数字, 然后是 B , 然后又是 A 如此继续.
 * 每一次都只取一个数, 每个数只能取一次. 等到数组内分数都被取完后, 分数大的那个玩家获胜.
 * 任意给定数组，预测玩家 A 能否胜利
 *
 *
 * 这个题目类似： L_0395_Coins_in_a_Line_II
 * 
 * @author  rays1
 * @url     https://www.lintcode.com/problem/predict-the-winner/description
 * 
 */
public class L_0670_Predict_the_Winner {

    /**
     * 定义 dp[l][r] 为玩家从 l 和 r 开始，能够比另一个玩家多拿的分数
     * 
     * 如果 A 从左边开始拿，则 dp[l-1][r] 是 B 能够多拿的分数
     *      dp[l][r] = nums[l] - dp[l+1][r]
     *      
     * 如果 A 从右边开始拿，则 dp[l][r-1] 是 B 能够多拿的分数
     *      dp[l][r] = nums[l] - dp[l][r-1]
     * 
     * 每个人在选择时，均遵循最大化的选择
     *      dp[l][r] = max {nums[l] - dp[l+1][r], nums[l] - dp[l][r-1]}
     *      
     * @author rays1
     *
     */
    static class Solution {
    
        public boolean PredictTheWinner(int[] nums) {
            int[][] dp = new int[nums.length][nums.length];
            
            for (int l = nums.length-1; l >= 0; l--) {
                dp[l][l] = nums[l];
                for (int r = l+1; r < nums.length; r ++) {
                    dp[l][r] = Math.max(nums[l] - dp[l+1][r], nums[r]-dp[l][r-1]);
                }
            }
            
            return dp[0][nums.length-1] > 0;
        }
    
    }
    
    public static void main(String[] args) {
        
        int[] nums = {1, 5, 233, 7};
        
        Out.p(new Solution().PredictTheWinner(nums));
        
    }

}
