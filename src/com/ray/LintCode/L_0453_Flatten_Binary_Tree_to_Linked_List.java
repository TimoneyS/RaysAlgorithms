package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      Flatten a binary tree to a fake "linked list" in pre-order traversal.
 *      
 *      Here we use the *right* pointer in TreeNode as the *next* pointer in ListNode.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input:{1,2,5,3,4,#,6}
 *      Output：{1,#,2,#,3,#,4,#,5,#,6}
 *      Explanation：
 *           1
 *          / \
 *         2   5
 *        / \   \
 *       3   4   6
 *      
 *      1
 *      \
 *       2
 *        \
 *         3
 *          \
 *           4
 *            \
 *             5
 *              \
 *               6
 *      ```
 *      **Example 2:**
 *      ```
 *      Input:{1}
 *      Output:{1}
 *      Explanation：
 *               1
 *               1
 *      ```
 *
 * 挑战：
 *      Do it in-place without any extra memory.
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/flatten-binary-tree-to-linked-list/description
 * @date   2019-07-11 18:33:16
 */
public class L_0453_Flatten_Binary_Tree_to_Linked_List {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
