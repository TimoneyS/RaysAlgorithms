package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      Design an iterator over a binary search tree with the following rules:
 *      
 *      - Elements are visited in ascending order (i.e. an in-order traversal)
 *      - `next()` and `hasNext()` queries run in O(*1*) time in **average**.
 *
 * 用例：
 *      **Example 1**
 *      
 *      ```
 *      Input:  {10,1,11,#,6,#,12}
 *      Output:  [1, 6, 10, 11, 12]
 *      Explanation:
 *      The BST is look like this:
 *        10
 *        /\
 *       1 11
 *        \  \
 *         6  12
 *      You can return the inorder traversal of a BST [1, 6, 10, 11, 12]
 *      ```
 *      
 *      **Example 2**
 *      
 *      ``` plain
 *      Input: {2,1,3}
 *      Output: [1,2,3]
 *      Explanation:
 *      The BST is look like this:
 *        2
 *       / \
 *      1   3
 *      You can return the inorder traversal of a BST tree [1,2,3]
 *      ```
 *
 * 挑战：
 *      Extra memory usage O(h), h is the height of the tree.
 *      
 *      **Super Star**: Extra memory usage O(1)
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/binary-search-tree-iterator/description
 * @date   2019-07-11 18:30:02
 */
public class L_0086_Binary_Search_Tree_Iterator {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
