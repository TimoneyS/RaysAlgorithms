package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a binary search tree ([See Definition](http://www.lintcode.com/problem/validate-binary-search-tree/ "BST")) and a node in it, find the in-order successor of that node in the BST.
 *      
 *      If the given node has no in-order successor in the tree, return `null`.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: {1,#,2}, node with value 1
 *      Output: 2
 *      Explanation:
 *        1
 *         \
 *          2
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input: {2,1,3}, node with value 1
 *      Output: 2
 *      Explanation: 
 *          2
 *         / \
 *        1   3
 *      ```
 *      
 *      [Binary Tree Representation](https://www.lintcode.com/help/binary-tree-representation/)
 *
 * 挑战：
 *      O(h), where h is the height of the BST.
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/inorder-successor-in-bst/description
 * @date   2019-07-11 18:33:12
 */
public class L_0448_Inorder_Successor_in_BST {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
