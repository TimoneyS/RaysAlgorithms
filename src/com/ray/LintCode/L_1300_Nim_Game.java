package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   You are playing the following Nim Game with your friend: There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner. You will take the first turn to remove the stones.
 *   
 *   Both of you are very clever and have optimal strategies for the game. Write a function to determine whether you can win the game given the number of stones in the heap.
 *   
 *   For example, if there are 4 stones in the heap, then you will never win the game: no matter 1, 2, or 3 stones you remove, the last stone will always be removed by your friend.
 *
 * Example :
 *   **Example 1：**
 *   ```
 *   Input：n = 4 
 *   Output：False
 *   Explanation：Take 1, 2 or 3 first, the other party will take the last one
 *   ```
 *   
 *   **Example 2：**
 *   ```
 *   Input：n = 5 
 *   Output：True
 *   Explanation：Take 1 first，Than，we can win the game
 *   ```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/nim-game/description
 * @date   2019-07-03 17:43:19
 */
public class L_1300_Nim_Game {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
