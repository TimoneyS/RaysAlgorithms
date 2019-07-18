package com.ray.LintCode.temp;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import com.ray.LintCode.util.UndirectedGraphNode;
import com.ray.io.Out;

/**
 * 描述：
 *      Clone an undirected graph. Each node in the graph contains a `label` and a list of its `neighbors`. Nodes are labeled uniquely.
 *      
 *      You need to return a deep copied graph, which has the same structure as the original graph, and any changes to the new graph will not have any effect on the original graph.
 *
 * 用例：
 *      **Example1**
 *      ```
 *      Input:
 *      {1,2,4#2,1,4#4,1,2}
 *      Output: 
 *      {1,2,4#2,1,4#4,1,2}
 *      Explanation:
 *      1------2  
 *       \     |  
 *        \    |  
 *         \   |  
 *          \  |  
 *            4   
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/clone-graph/description
 * @date   2019-07-11 18:31:02
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
