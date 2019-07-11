package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a 2D grid, each cell is either a wall `'W'`, an enemy `'E'` or empty `'0'` (the number zero), return the maximum enemies you can kill using one bomb.
 *      The bomb kills all the enemies in the same row and column from the planted point until it hits the wall since the wall is too strong to be destroyed.
 *
 * 用例：
 *      **Example1**
 *      
 *      ```
 *      Input:
 *      grid =[
 *           "0E00",
 *           "E0WE",
 *           "0E00"
 *      ]
 *      Output: 3
 *      Explanation:
 *      Placing a bomb at (1,1) kills 3 enemies
 *      ```
 *      
 *      **Example2**
 *      
 *      ```
 *      Input:
 *      grid =[
 *           "0E00",
 *           "EEWE",
 *           "0E00"
 *      ]
 *      Output: 2
 *      Explanation:
 *      Placing a bomb at (0,0) or (0,3) or (2,0) or (2,3) kills 2 enemies
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/bomb-enemy/description
 * @date   2019-07-11 18:33:58
 */
public class L_0553_Bomb_Enemy {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
