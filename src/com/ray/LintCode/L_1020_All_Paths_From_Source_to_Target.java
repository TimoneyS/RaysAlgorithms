package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   Given a directed, acyclic graph of `N` nodes.  Find all possible paths from node `0` to node `N-1`, and return them in any order.
 *   
 *   The `graph` is given as follows:  the nodes are 0, 1, ..., graph.length - 1.  graph[i] is a list of all nodes j for which the edge i->j exists.
 *
 * Example :
 *   **Example 1:**
 *   
 *   ```
 *   Input: [[1,2],[3],[3],[]] 
 *   Output: [[0,1,3],[0,2,3]] 
 *   Explanation: The graph looks like this:
 *     0--->1
 *     |    |
 *     v    v
 *     2--->3
 *     There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
 *   ```
 *   
 *   **Example 2:**
 *   
 *   ```
 *   Input: [[1,3],[2],[3],[]]
 *   Output: [[0,1,2,3],[0,3]]
 *   ```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/all-paths-from-source-to-target/description
 * @date   2019-07-03 17:36:33
 */
public class L_1020_All_Paths_From_Source_to_Target {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
