package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   In a directed graph, we start at some node and every turn, walk along a directed edge of the graph.  If we reach a node that is terminal (that is, it has no outgoing directed edges), we stop.

Now, say our starting node is eventually safe if and only if we must eventually walk to a terminal node.  More specifically, there exists a natural number K so that for **any choice** of where to walk, we must have stopped at a terminal node in less than K steps.

Which nodes are eventually safe?  Return them as an array in ascending order.

The directed graph has N nodes with labels 0, 1, ..., N-1, where N is the length of graph.  The `graph` is given in the following form: `graph[i]` is a list of labels j such that (i, j) is a directed edge of the graph.
 *
 * Example :
 *   **Example 1:**

```
Input: [[1,2],[2,3],[5],[0],[5],[],[]]
Output: [2,4,5,6]
```

**Example 2:**

```
Input: [[4,9],[3,5,7],[0,3,4,5,6,8],[7,8,9],[5,6,7,8],[6,7,8,9],[7,9],[8,9],[9],[]]
Output: [0,1,2,3,4,5,6,7,8,9]
```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/find-eventual-safe-states/description
 * @date   2019-07-03 17:36:24
 */
public class L_1015_Find_Eventual_Safe_States {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
