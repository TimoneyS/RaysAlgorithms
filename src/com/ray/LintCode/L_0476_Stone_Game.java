package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      There is a stone game.At the beginning of the game the player picks `n` piles of stones in a line.
 *      
 *      The goal is to merge the stones in one pile observing the following rules: 
 *      
 *      1. At each step of the game,the player can merge two adjacent piles to a new pile.
 *      2. The score is the number of stones in the new pile. 
 *      
 *      You are to determine the minimum of the total score.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: [3, 4, 3]
 *      Output: 17
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input: [4, 1, 1, 4]
 *      Output: 18
 *      Explanation:
 *        1. Merge second and third piles => [4, 2, 4], score = 2
 *        2. Merge the first two piles => [6, 4]，score = 8
 *        3. Merge the last two piles => [10], score = 18
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/stone-game/description
 * @date   2019-07-11 18:33:25
 */
public class L_0476_Stone_Game {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
