package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      You have 4 cards each containing a number from `1` to `9`. You need to compute whether they could operated through `*`, `/`, `+`, `-`, `(`, `)` to get the value of `24`.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input：[1, 4, 8, 7]
 *      Output：true
 *      Explanation：8 * （7 - 4） * 1 = 24
 *      ```
 *      
 *      **Example 2:**
 *      ```
 *      Input：[1, 1, 1, 2]
 *      Output：true
 *      Explanation：no way to get 24
 *      ```
 *      
 *      
 *      **Example 3:**
 *      ```
 *      Input：[3, 3, 8, 8]
 *      Output：true
 *      Explanation：8 / ( 3 - 8 / 3) = 24
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/24-game/description
 * @date   2019-07-11 18:35:57
 */
public class L_0739_24_Game {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
