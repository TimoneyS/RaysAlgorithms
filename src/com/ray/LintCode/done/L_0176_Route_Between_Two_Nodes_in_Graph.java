package com.ray.LintCode.done;

import java.util.ArrayList;
import java.util.HashSet;

import com.ray.LintCode.util.DirectedGraphNode;

/**
 * 描述：
 *      Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
 *
 * 用例：
 *      Given graph:
 *      ```
 *        	A----->B----->C
 *      	 \     |
 *      	  \    |
 *      	   \   |
 *      	    \  v
 *      	     ->D----->E
 *      
 *      Example 1:
 *      Input:s = B and t = E,
 *      Output:true
 *      
 *      Example 2:
 *      Input:s = D and t = C,
 *      Output:false
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/route-between-two-nodes-in-graph/description
 * @date   2019-07-11 18:31:36
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
