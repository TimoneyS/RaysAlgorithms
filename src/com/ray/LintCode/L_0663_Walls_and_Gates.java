package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      You are given a m x n 2D grid initialized with these three possible values.
 *      
 *      `-1`  - A wall or an obstacle.
 *      `0`   - A gate.
 *      `INF` - Infinity means an empty room. We use the value `2^31 - 1 = 2147483647` to represent INF as you may assume that the distance to a gate is less than `2147483647`.
 *      Fill each empty room with the distance to its nearest gate. If it is impossible to reach a `ROOM`, that room should remain filled with `INF`
 *
 * 用例：
 *      **Example1**
 *      ```
 *      Input:
 *      [[2147483647,-1,0,2147483647],[2147483647,2147483647,2147483647,-1],[2147483647,-1,2147483647,-1],[0,-1,2147483647,2147483647]]
 *      Output:
 *      [[3,-1,0,1],[2,2,1,-1],[1,-1,2,-1],[0,-1,3,4]]
 *      
 *      Explanation:
 *      the 2D grid is:
 *      INF  -1  0  INF
 *      INF INF INF  -1
 *      INF  -1 INF  -1
 *        0  -1 INF INF
 *      the answer is:
 *        3  -1   0   1
 *        2   2   1  -1
 *        1  -1   2  -1
 *        0  -1   3   4
 *      ```
 *      **Example2**
 *      ```
 *      Input:
 *      [[0,-1],[2147483647,2147483647]]
 *      Output:
 *      [[0,-1],[1,2]]
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/walls-and-gates/description
 * @date   2019-07-11 18:35:14
 */
public class L_0663_Walls_and_Gates {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
