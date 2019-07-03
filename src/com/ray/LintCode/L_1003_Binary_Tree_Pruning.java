package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   Given the head node **root** of a binary tree, where additionally every node's value is either a 0 or a 1.

Return this tree where every subtree (of the given tree) not containing a 1 has been removed.

(Recall that the subtree of a node X is X, plus every node that is a descendant of X.)
 *
 * Example :
 *   **Example 1:**
```
Input: {1,#,0,0,1}
Output: {1,#,0,#,1}
Explanation: 
  Only the red nodes satisfy the property "every subtree not containing a 1".
  The diagram on the right represents the answer.
```
![](https://lintcode-media.s3.amazonaws.com/problem/1028_2.png "")

**Example 2:**
```
Input: {1,0,1,0,0,0,1}
Output: {1,#,1,#,1}
```
![](https://lintcode-media.s3.amazonaws.com/problem/1028_1.png "")

**Example 3:**
```
Input: {1,1,0,1,1,0,1,0}
Output: {1,1,0,1,1,#,1}
```
![](https://lintcode-media.s3.amazonaws.com/problem/1028.png "")
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/binary-tree-pruning/description
 * @date   2019-07-03 17:36:08
 */
public class L_1003_Binary_Tree_Pruning {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
