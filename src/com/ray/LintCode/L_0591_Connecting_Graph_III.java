package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      Given `n` nodes in a graph labeled from `1` to `n`. There is no edges in the graph at beginning.
 *      
 *      You need to support the following method:
 *      1. `connect(a, b)`, an edge to connect node a and node b
 *      2. `query()`, Returns the number of connected component in the graph
 *
 * 用例：
 *      Example 1:
 *      ```
 *      Input:
 *      ConnectingGraph3(5)
 *      query()
 *      connect(1, 2)
 *      query()
 *      connect(2, 4)
 *      query()
 *      connect(1, 4)
 *      query()
 *      
 *      Output:[5,4,3,3]
 *      
 *      ```
 *      
 *      Example 2:
 *      ```
 *      Input:
 *      ConnectingGraph3(6)
 *      query()
 *      query()
 *      query()
 *      query()
 *      query()
 *      
 *      
 *      Output:
 *      [6,6,6,6,6]
 *      
 *      
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/connecting-graph-iii/description
 * @date   2019-07-11 18:34:21
 */
public class L_0591_Connecting_Graph_III {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
