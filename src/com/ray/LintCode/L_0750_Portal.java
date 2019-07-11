package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      Chell is the protagonist of the Portal Video game series developed by Valve Corporation.
 *      One day, She fell into a maze. The maze can be thought of as an array of 2D characters of size `n x m`. It has `4` kinds of rooms. `'S'` represents where Chell started(Only one starting point). `'E'` represents the exit of the maze(When chell arrives, she will leave the maze, this question may have multiple exits). `'*'` represents the room that Chell can pass. `'#'` represents a wall, Chell can not pass the wall. 
 *      She can spend a minute moving up,down,left and right to reach a room, but she can not reach the wall.
 *      Now, can you tell me how much time she needs **at least** to leave the maze?
 *      If she can not leave, return `-1`.
 *
 * 用例：
 *      **Example1**
 *      
 *      ```
 *      Input: 
 *      [
 *          ['S','E','*'],
 *          ['*','*','*'],
 *          ['*','*','*']
 *      ]
 *      Output: 1
 *      Explanation:
 *      Chell spent one minute walking from (0,0) to (0,1).
 *      ```
 *      
 *      **Example2**
 *      
 *      ```
 *      Input: 
 *      [
 *          ['S','#','#'], 
 *          ['#','*','#'], 
 *          ['#','*','*'], 
 *          ['#','*','E']
 *      ]
 *      Output: -1
 *      Explanation:
 *      Chell can not leave the maze.
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/portal/description
 * @date   2019-07-11 18:36:02
 */
public class L_0750_Portal {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
