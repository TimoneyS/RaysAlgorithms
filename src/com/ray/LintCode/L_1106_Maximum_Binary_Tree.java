package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:
 *   
 *   * The root is the maximum number in the array.
 *   * The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
 *   * The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
 *   
 *   Construct the maximum tree by the given array and return the root node of this tree.
 *
 * Example :
 *   **Example 1:**

```
Input: {3,2,1,6,0,5}
Output: Return the tree root node representing the following tree:
     6
   /   \
  3     5
   \   / 
    2 0   
     \
      1
```

**Example 2:**

```
Input: {1,2,3,4}
Output: Return the tree root node representing the following tree:
        4
       /
      3
     /
    2
   /
  1    
```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/maximum-binary-tree/description
 * @date   2019-07-03 17:38:51
 */
public class L_1106_Maximum_Binary_Tree {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
