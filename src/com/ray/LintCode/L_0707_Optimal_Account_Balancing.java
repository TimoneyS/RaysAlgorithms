package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a directed graph where each edge is represented by a `tuple`, such as `[u, v, w] `represents an edge with a weight `w` from `u` to `v`.
 *      You need to calculate at least the need to add the number of edges to ensure that each point of the weight are balancing. That is, the sum of weight of the edge pointing to this point is equal to the sum of weight of the edge of the point that points to the other point.
 *
 * 用例：
 *      **Example 1**
 *      
 *      ```plain
 *      Input: [[0,1,10],[2,0,5]]
 *      Output: 2
 *      Explanation:
 *      Two edges are need to added. There are [1,0,5] and [1,2,5]
 *      ```
 *      
 *      **Example 2**
 *      
 *      ```plain
 *      Input: [[0,1,10],[1,0,1],[1,2,5],[2,0,5]]
 *      Output: 1
 *      Explanation:
 *      Only one edge need to added. There is [1,0,4]
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Super
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/optimal-account-balancing/description
 * @date   2019-07-11 18:35:43
 */
public class L_0707_Optimal_Account_Balancing {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
