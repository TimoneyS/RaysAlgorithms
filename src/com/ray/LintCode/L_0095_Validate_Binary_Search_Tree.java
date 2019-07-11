package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a binary tree, determine if it is a valid binary search tree (BST).
 *      
 *      Assume a BST is defined as follows:
 *      
 *      - The left subtree of a node contains only nodes with keys **less than** the node's key.
 *      - The right subtree of a node contains only nodes with keys **greater than** the node's key.
 *      - Both the left and right subtrees must also be binary search trees.
 *      - A single node tree is a BST
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input:  {-1}
 *      Output：true
 *      Explanation：
 *      For the following binary tree（only one node）:
 *      	      -1
 *      This is a binary search tree.
 *      ```	
 *      
 *      **Example 2:**
 *      ```
 *      Input:  {2,1,4,#,#,3,5}
 *      Output: true
 *      For the following binary tree:
 *      	  2
 *      	 / \
 *      	1   4
 *      	   / \
 *      	  3   5
 *      This is a binary search tree.
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/validate-binary-search-tree/description
 * @date   2019-07-11 18:30:10
 */
public class L_0095_Validate_Binary_Search_Tree {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
