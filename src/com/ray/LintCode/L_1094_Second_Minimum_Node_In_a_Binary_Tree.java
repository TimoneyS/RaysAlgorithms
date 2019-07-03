package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly `two` or `zero` sub-node. If the node has two sub-nodes, then this node's value is not bigger than  its two sub-nodes.

Given such a binary tree, you need to output the **second minimum** value in the set made of all the nodes' value in the whole tree.

If no such second minimum value exists, output -1 instead.
 *
 * Example :
 *   **Example 1:**
```
Input: 
    2
   / \
  2   5
     / \
    5   7

Output: 5
Explanation: The smallest value is 2, the second smallest value is 5.
```

**Example 2:**
```
Input: 
    2
   / \
  2   2

Output: -1
Explanation: The smallest value is 2, but there isn't any second smallest value.
```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/second-minimum-node-in-a-binary-tree/description
 * @date   2019-07-03 17:38:37
 */
public class L_1094_Second_Minimum_Node_In_a_Binary_Tree {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
