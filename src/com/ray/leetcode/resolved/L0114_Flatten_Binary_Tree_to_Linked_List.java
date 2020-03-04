package com.ray.leetcode.resolved;

import com.ray.io.Out;
import com.ray.leetcode.util.TreeNode;

/**
 * Flatten Binary Tree to Linked List
 * -----------------------------------------------------------------------------
 * Given a binary tree, flatten it to a linked list in-place.
 * For example, given the following tree:
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * The flattened tree should look like:
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 * Example:
 *      
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 * @since   2020-03-04 21:35:11
 */
public class L0114_Flatten_Binary_Tree_to_Linked_List {
    /**
     * 将右结点放入左结点的最右侧，然后将左结点变为右结点。
     * 然后继续处理新的右结点。
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
