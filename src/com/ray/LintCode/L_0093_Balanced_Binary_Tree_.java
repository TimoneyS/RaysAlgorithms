package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a binary tree, determine if it is height-balanced.
 *      
 *      For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * 用例：
 *      ``` 
 *      Example  1:
 *      	Input: tree = {1,2,3}
 *      	Output: true
 *      	
 *      	Explanation:
 *      	This is a balanced binary tree.
 *      		  1  
 *      		 / \                
 *      		2  3
 *      
 *      	
 *      Example  2:
 *      	Input: tree = {3,9,20,#,#,15,7}
 *      	Output: true
 *      	
 *      	Explanation:
 *      	This is a balanced binary tree.
 *      		  3  
 *      		 / \                
 *      		9  20                
 *      		  /  \                
 *      		 15   7 
 *      
 *      	
 *      Example  3:
 *      	Input: tree = {1,#,2,3,4}
 *      	Output: false
 *      	
 *      	Explanation:
 *      	This is not a balanced tree. 
 *      	The height of node 1's right sub-tree is 2 but left sub-tree is 0.
 *      		  1  
 *      		   \                
 *      		   2                
 *      		  /  \                
 *      		 3   4
 *      	
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/balanced-binary-tree/description
 * @date   2019-07-11 18:30:08
 */
public class L_0093_Balanced_Binary_Tree_ {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
