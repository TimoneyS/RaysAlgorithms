package com.ray.LintCode.resolved;

import java.util.ArrayList;
import java.util.HashSet;

import com.ray.LintCode.util.DirectedGraphNode;

/**
 * Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
 *
 * @author rays1
 *
 */
public class L_0176_Route_Between_Two_Nodes_in_Graph {

    static class Solution {
        public boolean hasRoute(ArrayList<DirectedGraphNode> graph, DirectedGraphNode s, DirectedGraphNode t) {
            
            HashSet<Integer> marked = new HashSet<>();
            
            marked.add(s.label);
            dfs(s, t, marked);
            return marked.contains(t.label);
        }
        
        public void dfs(DirectedGraphNode s, DirectedGraphNode t, HashSet<Integer> marked) {
            for (DirectedGraphNode n : s.neighbors) {
                if (!marked.contains(n.label)) {
                    marked.add(n.label);
                    dfs(n, t, marked);
                    if (marked.contains(t.label))
                        break;
                }
            }
            
        }
        
    }

}
