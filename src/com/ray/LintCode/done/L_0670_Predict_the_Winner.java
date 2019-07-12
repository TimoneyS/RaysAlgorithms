package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      Given an array of scores that are non-negative integers. Player 1 picks one of the numbers from either end of the array followed by the player 2 and then player 1 and so on. Each time a player picks a number, that number will not be available for the next player. This continues until all the scores have been chosen. The player with the maximum score wins.
 *      
 *      Given an array of scores, predict whether player 1 is the winner. You can assume each player plays to maximize his score.
 *
 * 用例：
 *      **Example1**
 *      ```
 *      Input: [1, 5, 2]
 *      Output: false
 *      Explanation:
 *      Initially, player 1 can choose between 1 and 2. If he chooses 2 (or 1), then player 2 can choose from 1 (or 2) and 5. If player 2 chooses 5, then player 1 will be left with 1 (or 2). So, final score of player 1 is 1 + 2 = 3, and player 2 is 5. Hence, player 1 will never be the winner and you need to return False.
 *      ```
 *      **Example2**
 *      ```
 *      Input: [1, 5, 233, 7]
 *      Output: true
 *      Explanation: 
 *      Player 1 first chooses 1. Then player 2 have to choose between 5 and 7. No matter which number player 2 choose, player 1 can choose 233. Finally, player 1 has more score (234) than player 2 (12), so you need to return True representing player1 can win.
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/predict-the-winner/description
 * @date   2019-07-11 18:35:20
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
        
        Out.p(new Solution());
        
    }

}
