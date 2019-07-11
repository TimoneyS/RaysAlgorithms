package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      Given an directed graph, a topological order of the graph nodes is defined as follow:
 *      
 *      - For each directed edge `A -> B` in graph, A must before B in the order list.
 *      - The first node in the order can be any node in the graph with no nodes direct to it.
 *      
 *      Find any topological order for the given graph.
 *
 * 用例：
 *      For graph as follow: 
 *      
 *      ![picture](https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcThE9AgZZszyhwe0o9qpp3VyizdIj9kWwMY50HiQEysXvkSLsoZ)
 *      
 *      
 *      The topological order can be:
 *      
 *          [0, 1, 2, 3, 4, 5]
 *          [0, 2, 3, 1, 5, 4]
 *          ...
 *
 * 挑战：
 *      Can you do it in both BFS and DFS?
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/topological-sorting/description
 * @date   2019-07-11 18:30:54
 */
public class L_0127_Topological_Sorting {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
