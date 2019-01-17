package com.ray.LintCode.resolved;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import com.ray.LintCode.util.UndirectedGraphNode;
import com.ray.io.Out;

/**
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 * How we serialize an undirected graph:
 *  Nodes are labeled uniquely.
 *  We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
 *  
 * @author rays1
 *
 */
public class L_0137_Clone_Graph {

    static class Solution {
        
        Map<Integer, UndirectedGraphNode> cache = new HashMap<>();
        
        public UndirectedGraphNode cloneGraph(UndirectedGraphNode begin) {
            
            if (begin == null ) return begin;
            
            Queue<UndirectedGraphNode> queue = new LinkedList<>();
            
            queue.offer(begin);
            while (!queue.isEmpty()) {
                UndirectedGraphNode node = queue.poll();
                UndirectedGraphNode newNode = getNode(label(node));
                
                for (UndirectedGraphNode n : node.neighbors) {
                    if (n == node) continue;
                    if (!cache.containsKey(label(n))) {
                        queue.offer(n);
                    }
                    UndirectedGraphNode newChNode = getNode(label(n));
                    newNode.neighbors.add(newChNode);
                }
                
            }
            
            return cache.get(begin.label);
        }
        
        public int label(UndirectedGraphNode node) {
            return node == null ? -1 : node.label;
        }
        
        public UndirectedGraphNode getNode(int label) {
            UndirectedGraphNode node = cache.get(label);
            if (node == null) {
                node = new UndirectedGraphNode(label);
                cache.put(label, node);
            }
            return node;
        }
        
    }
    
    public static void main(String[] args) {
        
        UndirectedGraphNode begin = UndirectedGraphNode.parse("{1,2,3#2,3}");
        
        UndirectedGraphNode node = new Solution().cloneGraph(begin); 
        Out.p(node);
        Out.p(node.neighbors);
        
    }

}
