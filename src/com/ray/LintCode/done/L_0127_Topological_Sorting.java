package com.ray.LintCode.done;

import java.util.ArrayList;

import com.ray.LintCode.util.DirectedGraphNode;
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

    /**
     * 深度优先的拓扑排序，广度优先的未实现，原理为每次删除入度为 0 的顶点。
     * @author rays1
     *
     */
    static class Solution {
        
        boolean[] marked;
        
        public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
            
            marked = new boolean[graph.size()];
            ArrayList<DirectedGraphNode> rs = new ArrayList<>();
            
            for (DirectedGraphNode n : graph) {
                if (!marked[n.label])
                    dfs(n, rs);
            }
            return rs;
        }
        
        public void dfs(DirectedGraphNode n, ArrayList<DirectedGraphNode> stack) {
            marked[n.label] = true;
            for (DirectedGraphNode n2 : n.neighbors) {
                if (!marked[n2.label])
                    dfs(n2, stack);
            }
            stack.add(0, n);
        }
        
    }
    
    public static void main(String[] args) {
        String s = "{0,1,2,3#1,4#2,4,5#3,4,5}";
        Out.p(new Solution().topSort(DirectedGraphNode.parse(s)));
    }

}
