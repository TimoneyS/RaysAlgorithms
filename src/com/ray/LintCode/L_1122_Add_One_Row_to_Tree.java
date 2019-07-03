package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   Given the root of a binary tree, then value v and depth d, you need to add a row of nodes with value v at the given depth d. The root node is at depth 1.
 *   
 *   The adding rule is: given a positive integer depth d, for each NOT null tree nodes N in depth d-1, create two tree nodes with value v as N's left subtree root and right subtree root. And N's original left subtree should be the left subtree of the new left subtree root, its original right subtree should be the right subtree of the new right subtree root. If depth d is 1 that means there is no depth d-1 at all, then create a tree node with value v as the new root of the whole original tree, and the original tree is the new root's left subtree.
 *
 * Example :
 *   **Example1**
 *   ```
 *   Input: 
 *   A binary tree as following:
 *          4
 *        /   \
 *       2     6
 *      / \   / 
 *     3   1 5   
 *   v = 1
 *   d = 2
 *   Output: 
 *          4
 *         / \
 *        1   1
 *       /     \
 *      2       6
 *     / \     / 
 *    3   1   5   
 *   ```
 *   
 *   **Example2**
 *   ```
 *   Input: 
 *   A binary tree as following:
 *          4
 *        /   \
 *       2     6
 *      / \   / 
 *     3   1 5   
 *   v = 2
 *   d = 1
 *   Output: 
 *            2
 *     	/
 *          4
 *        /   \
 *       2     6
 *      / \   / 
 *     3   1 5     
 *   ```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/add-one-row-to-tree/description
 * @date   2019-07-03 17:39:08
 */
public class L_1122_Add_One_Row_to_Tree {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
