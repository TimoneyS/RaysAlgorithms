package com.ray.LintCode.resolved;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import com.ray.LintCode.util.UndirectedGraphNode;
import com.ray.io.Out;

/**
 * Given an undirected graph in which each edge's length is 1, and two nodes from the graph.
 * Return the length of the shortest path between two given nodes.
 *
 * @author rays1
 *
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
