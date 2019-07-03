package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   Given a Binary Search Tree (BST) with the root node root, return the minimum difference between the values of any two different nodes in the tree.
 *
 * Example :
 *   **Example 1:**
```
Input: root = {4,2,6,1,3,#,#}
Output: 1
Explanation:
Note that root is a TreeNode object, not an array.

The given tree {4,2,6,1,3,#,#} is represented by the following diagram:

          4
        /   \
      2      6
     / \    
    1   3  

while the minimum difference in this tree is 1, it occurs between node 1 and node 2, also between node 3 and node 2.
```

**Example 2:**
```
Input: root = {5,1,8}
Output: 3
Explanation:
Note that root is a TreeNode object, not an array.

The given tree {5,1,8} is represented by the following diagram:

     5
   /   \
 1      8
 
while the minimum difference in this tree is 3, it occurs between node 5 and node 8.
```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/minimum-difference-between-bst-nodes/description
 * @date   2019-07-03 17:36:57
 */
public class L_1033_Minimum_Difference_Between_BST_Nodes {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
