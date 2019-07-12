package com.ray.LintCode.done;

import com.ray.LintCode.util.TreeNode;
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

    /**
     * 将右结点放入左结点的最右侧，然后将左结点变为右结点。
     * 然后继续处理新的右结点。
     * @author rays1
     *
     */
    static class Solution {
    
        public void flatten(TreeNode root) {
            while (root != null) {
                if (root.left == null) {
                    root = root.right;
                } else {
                    if (root.right != null) putToRight(root.left, root.right);
                    root.right = root.left;
                    root.left = null;
                    
                    root = root.right;
                }
                
            }
        }
        
        void putToRight(TreeNode root, TreeNode node) {
            while (root.right != null) root = root.right;
            root.right = node;
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
