package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   Given a binary tree, return the tilt of the **whole tree**.

The tilt of a **tree node** is defined as the **absolute difference** between the sum of all left subtree node values and the sum of all right subtree node values. Null node has tilt 0.

The tilt of the **whole tree** is defined as the sum of all nodes' tilt.
 *
 * Example :
 *   **Example 1:**
```
Input: 
{1,2,3}
Output: 1

Explanation: 
         1
       /   \
      2     3
Tilt of node 2 : 0
Tilt of node 3 : 0
Tilt of node 1 : |2-3| = 1
Tilt of binary tree : 0 + 0 + 1 = 1
```

**Example 2: **
```
Input：
{1,1,#,2,3}
Output：
7

Explanation：
        1
      /
    1
   /  \
2     3
```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/binary-tree-tilt/description
 * @date   2019-07-03 17:40:20
 */
public class L_1172_Binary_Tree_Tilt {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
