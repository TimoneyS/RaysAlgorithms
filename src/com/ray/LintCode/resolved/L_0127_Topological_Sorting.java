package com.ray.LintCode.resolved;

import java.util.ArrayList;

import com.ray.io.Out;

/**
 * Given an directed graph, a topological order of the graph nodes is defined as follow:
 * Find any topological order for the given graph.
 * 有向图寻找任意拓扑排序
 * 
 * @author rays1
 *
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
