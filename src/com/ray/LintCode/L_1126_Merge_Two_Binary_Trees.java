package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.
 *   
 *   You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.
 *
 * Example :
 *   **Example1**
```
Input: 
{1,3,2,5}
{2,1,3,#,4,#,7}
Output:
{3,4,5,5,4,#,7}
Explanation:
	Tree 1                     Tree 2                  
          1                         2                             
         / \                       / \                            
        3   2                     1   3                        
       /                           \   \                      
      5                             4   7                  

Merged tree:
	     3
	    / \
	   4   5
	  / \   \ 
	 5   4   7
```
**Example2**
```
Input: 
{1}
{1,2}
Output:
{2,2}
```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/merge-two-binary-trees/description
 * @date   2019-07-03 17:39:09
 */
public class L_1126_Merge_Two_Binary_Trees {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
