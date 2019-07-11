package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      You are playing the following Flip Game with your friend: Given a string that contains only these two characters: `+` and `-`, you and your friend take turns to flip two **consecutive** `"++"` into `"--"`. The game ends when a person can no longer make a move and therefore the other person will be the winner.
 *      
 *      Write a function to determine if the starting player can guarantee a win.
 *
 * 用例：
 *      **Example1**
 *      
 *      ```
 *      Input:  s = "++++"
 *      Output: true
 *      Explanation:
 *      The starting player can guarantee a win by flipping the middle "++" to become "+--+".
 *      ```
 *      
 *      **Example2**
 *      
 *      ```
 *      Input: s = "+++++"
 *      Output: false 
 *      Explanation:
 *      The starting player can not win 
 *      "+++--" --> "+----"
 *      "++--+" --> "----+"
 *      ```
 *
 * 挑战：
 *      Derive your algorithm's runtime complexity.
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/flip-game-ii/description
 * @date   2019-07-11 18:38:35
 */
public class L_0913_Flip_Game_II {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
