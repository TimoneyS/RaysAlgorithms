package com.ray.leetcode.resolved;

import com.ray.LintCode.util.TreeNode;
import com.ray.io.Out;

/**
 * Validate Binary Search Tree
 * -----------------------------------------------------------------------------
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
 * 	The left subtree of a node contains only nodes with keys less than the node's key.
 * 	The right subtree of a node contains only nodes with keys greater than the node's key.
 * 	Both the left and right subtrees must also be binary search trees.
 *
 * Example:
 *      Example 1
 *          2
 *         / \
 *        1   3
 *      Input: [2,1,3]
 *      Output: true
 *      Example 2
 *          5
 *         / \
 *        1   4
 *           / \
 *          3   6
 *      Input: [5,1,4,null,null,3,6]
 *      Output: false
 *      Explanation: The root node's value is 5 but its right child's value is 4.
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/validate-binary-search-tree/
 * @since   2020-03-03 23:09:36
 */
public class L0098_Validate_Binary_Search_Tree {
    /**
     * 直接遍历，记录遍历的前一个结点值
     */
    static class Solution {
        Integer prev = null;
        public boolean isValidBST(TreeNode root) {
            if (root == null) return true;
            boolean rs = isValidBST(root.left);
            if (prev != null)
                rs &= (root.val > prev);
            if (rs) {
                prev = root.val;
                rs = isValidBST(root.right);
            }
            return rs;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
