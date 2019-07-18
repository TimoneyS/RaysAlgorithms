package com.ray.LintCode.temp;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import com.ray.LintCode.util.UndirectedGraphNode;
import com.ray.io.Out;

/**
 * 描述：
 *      Given an undirected graph in which each edge's length is 1, and two nodes from the graph. Return the length of the shortest path between two given nodes.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: graph = {1,2,4#2,1,4#3,5#4,1,2#5,3}, node1 = 3, node2 = 5
 *      Output: 1
 *      Explanation:
 *        1------2  3
 *         \     |  | 
 *          \    |  |
 *           \   |  |
 *            \  |  |
 *              4   5
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input: graph = {1,2,3,4#2,1,3#3,1#4,1,5#5,4}, node1 = 1, node2 = 5
 *      Output: 2
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/shortest-path-in-undirected-graph/description
 * @date   2019-07-11 18:36:54
 */
public class L_0814_Shortest_Path_in_Undirected_Graph {

    static class Solution {
    
        public int shortestPath(List<UndirectedGraphNode> graph, UndirectedGraphNode A, UndirectedGraphNode B) {
            
            Queue<UndirectedGraphNode> queue = new ArrayDeque<>();
            
            int c1 = 1;
            int c2 = 0;
            int level = 0;
            
            queue.add(A);
            Set<Integer> marked = new HashSet<Integer>();
            while (!queue.isEmpty()) {
                
                if (c1 <= 0) {
                    level ++;
                    c1 = c2;
                    c2 = 0;
                }
                
                UndirectedGraphNode n = queue.poll();
                c1 --;
                if (n.label == B.label) return level;
                
                for (UndirectedGraphNode ch : n.neighbors) {
                    if (!marked.contains(ch.label)) {
                        marked.add(ch.label);
                        c2 ++;
                        queue.add(ch);
                    }
                }
                
            }
            
            return 0;
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
