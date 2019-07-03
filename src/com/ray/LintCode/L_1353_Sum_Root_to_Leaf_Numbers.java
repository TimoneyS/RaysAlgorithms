package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   Given a binary tree containing digits from `0-9` only, each root-to-leaf path could represent a number.
 *   
 *   An example is the root-to-leaf path `1->2->3` which represents the number `123`.
 *   
 *   Find the total sum of all root-to-leaf numbers.
 *
 * Example :
 *   **Example:**
```
Input: {1,2,3}
    1
   / \
  2   3
Output: 25
Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.
```
**Example 2:**
```
Input: {4,9,0,5,1}
    4
   / \
  9   0
 / \
5   1
Output: 1026
Explanation:
The root-to-leaf path 4->9->5 represents the number 495.
The root-to-leaf path 4->9->1 represents the number 491.
The root-to-leaf path 4->0 represents the number 40.
Therefore, sum = 495 + 491 + 40 = 1026.
```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/sum-root-to-leaf-numbers/description
 * @date   2019-07-03 17:44:49
 */
public class L_1353_Sum_Root_to_Leaf_Numbers {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
